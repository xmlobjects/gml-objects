package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.Coordinates;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class CoordinatesAdapter implements ObjectBuilder<Coordinates> {

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
}
