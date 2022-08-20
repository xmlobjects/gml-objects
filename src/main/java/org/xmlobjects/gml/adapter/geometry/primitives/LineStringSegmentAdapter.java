/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2022 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.CoordinatesAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionAdapter;
import org.xmlobjects.gml.adapter.geometry.DirectPositionListAdapter;
import org.xmlobjects.gml.adapter.geometry.GeometricPositionListAdapter;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.primitives.LineStringSegment;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "LineStringSegment", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "LineStringSegment", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class LineStringSegmentAdapter extends AbstractCurveSegmentAdapter<LineStringSegment> {

    @Override
    public LineStringSegment createObject(QName name, Object parent) throws ObjectBuildException {
        return new LineStringSegment();
    }

    @Override
    public void buildChildObject(LineStringSegment object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (GMLBuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "posList":
                    object.getControlPoints().setPosList(reader.getObjectUsingBuilder(DirectPositionListAdapter.class));
                    break;
                case "pos":
                    object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(DirectPositionAdapter.class)));
                    break;
                case "pointProperty":
                case "pointRep":
                    object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(PointPropertyAdapter.class)));
                    break;
                case "coordinates":
                    reader.getObjectUsingBuilder(CoordinatesAdapter.class).toDirectPositions().stream()
                            .map(GeometricPosition::new)
                            .forEach(object.getControlPoints().getGeometricPositions()::add);
                    break;
            }
        }
    }

    @Override
    public Element createElement(LineStringSegment object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(GMLSerializerHelper.getGMLBaseNamespace(namespaces), "LineStringSegment");
    }

    @Override
    public void writeChildElements(LineStringSegment object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetControlPoints()) {
            writer.getOrCreateSerializer(GeometricPositionListAdapter.class).writeChildElements(object.getControlPoints(), namespaces, writer);
        }
    }
}
