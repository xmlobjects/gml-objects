package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.basicTypes.CoordinatesBuilder;
import org.xmlobjects.gml.builder.deprecatedTypes.CoordBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionBuilder;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Point", namespaceURI = Constants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "Point", namespaceURI = Constants.GML_3_1_NAMESPACE_URI)
})
public class PointBuilder extends AbstractGeometricPrimitiveBuilder<Point> {

    @Override
    public Point createObject(QName name) {
        return new Point();
    }

    @Override
    public void buildNestedObject(Point object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildNestedObject(object, name, attributes, reader);

        switch (name.getLocalPart()) {
            case "pos":
                object.setPos(reader.getObjectUsingBuilder(DirectPositionBuilder.class));
                break;
            case "coordinates":
                object.setPos(reader.getObjectUsingBuilder(CoordinatesBuilder.class).toDirectPosition());
                break;
            case "coord":
                object.setPos(reader.getObjectUsingBuilder(CoordBuilder.class).toDirectPosition());
                break;
        }
    }
}
