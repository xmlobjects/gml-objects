package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.Coordinates;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class CoordinatesAdapter implements ObjectBuilder<Coordinates>, ObjectSerializer<Coordinates> {

    @Override
    public Coordinates createObject(QName name) {
        return new Coordinates();
    }

    @Override
    public void initializeObject(Coordinates object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("decimal").ifPresent(object::setDecimal);
        attributes.getValue("cs").ifPresent(object::setCoordinateSeparator);
        attributes.getValue("ts").ifPresent(object::setTupleSeparator);
    }

    @Override
    public void initializeElement(Element element, Coordinates object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(object.getValue());

        if (!object.getDecimal().equals(Coordinates.DEFAULT_DECIMAL))
            element.addAttribute("decimal", object.getDecimal());

        if (!object.getCoordinateSeparator().equals(Coordinates.DEFAULT_COORDINATE_SEPARATOR))
            element.addAttribute("cs", object.getCoordinateSeparator());

        if (!object.getTupleSeparator().equals(Coordinates.DEFAULT_TUPLE_SEPARATOR))
            element.addAttribute("ts", object.getTupleSeparator());
    }
}
