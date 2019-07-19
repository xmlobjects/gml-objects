package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.basicTypes.CoordinatesBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionListBuilder;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.primitives.LineStringSegment;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "LineStringSegment", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "LineStringSegment", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class LineStringSegmentBuilder extends AbstractCurveSegmentBuilder<LineStringSegment> {

    @Override
    public LineStringSegment createObject(QName name) {
        return new LineStringSegment();
    }

    @Override
    public void buildNestedObject(LineStringSegment object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "posList":
                object.getControlPoints().setPosList(reader.getObjectUsingBuilder(DirectPositionListBuilder.class));
                break;
            case "pos":
                object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(DirectPositionBuilder.class)));
                break;
            case "pointProperty":
            case "pointRep":
                object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(PointPropertyBuilder.class)));
                break;
            case "coordinates":
                reader.getObjectUsingBuilder(CoordinatesBuilder.class).toDirectPositions().stream()
                        .map(GeometricPosition::new)
                        .forEach(object.getControlPoints().getGeometricPositions()::add);
                break;
        }
    }
}
