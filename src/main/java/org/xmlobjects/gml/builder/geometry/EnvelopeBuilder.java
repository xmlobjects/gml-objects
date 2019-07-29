package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.basictypes.CoordinatesBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.deprecated.CoordBuilder;
import org.xmlobjects.gml.model.deprecated.Coord;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;
import java.util.List;

@XMLElements({
        @XMLElement(name = "Envelope", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Envelope", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class EnvelopeBuilder implements ObjectBuilder<Envelope>, ObjectSerializer<Envelope> {

    @Override
    public Envelope createObject(QName name) {
        return new Envelope();
    }

    @Override
    public void initializeObject(Envelope object, QName name, Attributes attributes, XMLReader reader) {
        BuilderHelper.buildSRSReference(object, attributes);
    }

    @Override
    public void buildChildObject(Envelope object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "lowerCorner":
                object.setLowerCorner(reader.getObjectUsingBuilder(DirectPositionBuilder.class));
                break;
            case "upperCorner":
                object.setUpperCorner(reader.getObjectUsingBuilder(DirectPositionBuilder.class));
                break;
            case "pos":
                DirectPosition pos = reader.getObjectUsingBuilder(DirectPositionBuilder.class);
                if (object.getLowerCorner() == null)
                    object.setLowerCorner(pos);
                else if (object.getUpperCorner() == null)
                    object.setUpperCorner(pos);
                break;
            case "coordinates":
                List<DirectPosition> positions = reader.getObjectUsingBuilder(CoordinatesBuilder.class).toDirectPositions();
                if (positions.size() > 1) {
                    object.setLowerCorner(positions.get(0));
                    object.setUpperCorner(positions.get(1));
                }
                break;
            case "coord":
                Coord coord = reader.getObjectUsingBuilder(CoordBuilder.class);
                if (object.getLowerCorner() == null)
                    object.setLowerCorner(coord.toDirectPosition());
                else if (object.getUpperCorner() == null)
                    object.setUpperCorner(coord.toDirectPosition());
                break;
        }
    }

    @Override
    public Element createElement(Envelope object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getTargetNamespace(namespaces), "Envelope");
    }

    @Override
    public void initializeElement(Element element, Envelope object, Namespaces namespaces, XMLWriter writer) {
        SerializerHelper.serializeSRSReference(element, object, namespaces);
    }

    @Override
    public void writeChildElements(Envelope object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        if (object.getLowerCorner() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "lowerCorner"), object.getLowerCorner(), DirectPositionBuilder.class, namespaces);

        if (object.getUpperCorner() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "upperCorner"), object.getUpperCorner(), DirectPositionBuilder.class, namespaces);
    }
}
