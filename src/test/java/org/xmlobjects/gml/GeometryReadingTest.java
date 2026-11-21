/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.xmlobjects.XMLObjects;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;
import org.xmlobjects.gml.model.geometry.primitives.LineString;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLReaderFactory;

import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeometryReadingTest {
    private static final String GML = "xmlns:gml=\"http://www.opengis.net/gml/3.2\"";
    private static XMLObjects xmlObjects;

    @BeforeAll
    static void setup() throws Exception {
        xmlObjects = XMLObjects.newInstance();
    }

    private static <T> T read(String xml, Class<T> type) throws Exception {
        try (XMLReader reader = XMLReaderFactory.newInstance(xmlObjects).createReader(new StringReader(xml))) {
            return xmlObjects.fromXML(reader, type);
        }
    }

    private static DirectPositionList posList(MultiCurve multiCurve) {
        return ((LineString) multiCurve.getCurveMember().getFirst().getObject()).getControlPoints().getPosList();
    }

    @Test
    void axisAndUomLabels() throws Exception {
        Point point = read("<gml:Point " + GML + "><gml:pos axisLabels=\"E N\" uomLabels=\"m m\">1 2</gml:pos></gml:Point>",
                Point.class);

        assertEquals(List.of("E", "N"), point.getPos().getAxisLabels());
        assertEquals(List.of("m", "m"), point.getPos().getUomLabels());
    }

    @Test
    void labelListsAreNeverNull() {
        DirectPosition pos = new DirectPosition();
        pos.getAxisLabels().add("E");
        pos.getUomLabels().add("m");
        assertEquals(List.of("E"), pos.getAxisLabels());
        assertEquals(List.of("m"), pos.getUomLabels());
    }

    @Test
    void srsDimensionOfParentGeometryWithoutSrsName() throws Exception {
        MultiCurve multiCurve = read("<gml:MultiCurve " + GML + "><gml:curveMember>" +
                "<gml:LineString srsDimension=\"2\"><gml:posList>0 0 10 0 10 10</gml:posList></gml:LineString>" +
                "</gml:curveMember></gml:MultiCurve>", MultiCurve.class);

        // three 2D points, not two 3D points
        assertEquals(List.of(0.0, 0.0, 0.0, 10.0, 0.0, 0.0, 10.0, 10.0, 0.0), posList(multiCurve).toCoordinateList3D());
    }

    @Test
    void nearestSrsDimensionWins() throws Exception {
        MultiCurve multiCurve = read("<gml:MultiCurve " + GML + " srsName=\"EPSG:25832\" srsDimension=\"3\"><gml:curveMember>" +
                "<gml:LineString srsDimension=\"2\"><gml:posList>0 0 10 0 10 10</gml:posList></gml:LineString>" +
                "</gml:curveMember></gml:MultiCurve>", MultiCurve.class);

        assertEquals(9, posList(multiCurve).toCoordinateList3D().size());
    }

    @Test
    void srsDimensionFromEnvelopeOfFeature() {
        LineString lineString = new LineString(new DirectPositionList(List.of(0.0, 0.0, 10.0, 0.0, 10.0, 10.0)));
        Envelope envelope = new Envelope();
        envelope.setSrsDimension(2);
        TestFeature feature = new TestFeature(lineString);
        feature.setBoundedBy(new BoundingShape(envelope));

        assertEquals(9, lineString.getControlPoints().getPosList().toCoordinateList3D().size());
    }

    @Test
    void defaultDimensionIsThree() throws Exception {
        MultiCurve multiCurve = read("<gml:MultiCurve " + GML + "><gml:curveMember>" +
                "<gml:LineString><gml:posList>0 0 0 10 10 10</gml:posList></gml:LineString>" +
                "</gml:curveMember></gml:MultiCurve>", MultiCurve.class);

        assertEquals(List.of(0.0, 0.0, 0.0, 10.0, 10.0, 10.0), posList(multiCurve).toCoordinateList3D());
    }

    @Test
    void countLargerThanNumberOfValues() throws Exception {
        MultiCurve multiCurve = read("<gml:MultiCurve " + GML + "><gml:curveMember>" +
                "<gml:LineString srsDimension=\"2\"><gml:posList count=\"10\">0 0 10 0 10 10</gml:posList></gml:LineString>" +
                "</gml:curveMember></gml:MultiCurve>", MultiCurve.class);

        // previously failed with an ArithmeticException (division by zero); now falls back to srsDimension
        assertEquals(9, assertDoesNotThrow(() -> posList(multiCurve).toCoordinateList3D()).size());
    }

    @Test
    void countDefinesDimension() throws Exception {
        MultiCurve multiCurve = read("<gml:MultiCurve " + GML + "><gml:curveMember>" +
                "<gml:LineString><gml:posList count=\"3\">0 0 10 0 10 10</gml:posList></gml:LineString>" +
                "</gml:curveMember></gml:MultiCurve>", MultiCurve.class);

        assertEquals(9, posList(multiCurve).toCoordinateList3D().size());
    }

    private static class TestFeature extends org.xmlobjects.gml.model.feature.AbstractFeature {
        TestFeature(LineString lineString) {
            asChild(lineString);
        }

        @Override
        protected void updateEnvelope(Envelope envelope, org.xmlobjects.gml.util.EnvelopeOptions options) {
        }
    }
}
