package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.Coordinates;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class CoordinatesBuilder implements ObjectBuilder<Coordinates> {

    @Override
    public Coordinates createObject(QName name) {
        return new Coordinates();
    }

    @Override
    public void initializeObject(Coordinates object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("decimal").ifPresent(object::setDecimal);
        attributes.getValue("cs").ifPresent(object::setCoordinateSeparator);
        attributes.getValue("ts").ifPresent(object::setTupleSeparator);
    }
}
