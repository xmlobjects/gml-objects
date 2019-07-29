package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.basictypes.CoordinatesBuilder;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.deprecated.CoordBuilder;
import org.xmlobjects.gml.builder.geometry.DirectPositionBuilder;
import org.xmlobjects.gml.model.geometry.primitives.Point;
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
        @XMLElement(name = "Point", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Point", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class PointBuilder extends AbstractGeometricPrimitiveBuilder<Point> {

    @Override
    public Point createObject(QName name) {
        return new Point();
    }

    @Override
    public void buildChildObject(Point object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);

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

    @Override
    public Element createElement(Point object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Point");
    }

    @Override
    public void writeChildElements(Point object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getPos() != null)
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getTargetNamespace(namespaces), "pos"), object.getPos(), DirectPositionBuilder.class, namespaces);
    }
}
