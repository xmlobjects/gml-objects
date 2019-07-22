package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.basicTypes.CoordinatesBuilder;
import org.xmlobjects.gml.builder.deprecatedTypes.CoordBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionListBuilder;
import org.xmlobjects.gml.model.geometry.GeometricPosition;
import org.xmlobjects.gml.model.geometry.primitives.LineString;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "LineString", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "LineString", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class LineStringBuilder extends AbstractCurveBuilder<LineString> {

    @Override
    public LineString createObject(QName name) {
        return new LineString();
    }

    @Override
    public void buildChildObject(LineString object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

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
            case "coord":
                object.getControlPoints().getGeometricPositions().add(new GeometricPosition(reader.getObjectUsingBuilder(CoordBuilder.class).toDirectPosition()));
                break;
        }
    }
}
