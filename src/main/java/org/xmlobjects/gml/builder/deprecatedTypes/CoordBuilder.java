package org.xmlobjects.gml.builder.deprecatedTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.deprecatedTypes.Coord;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class CoordBuilder implements ObjectBuilder<Coord> {

    @Override
    public Coord createObject(QName name) {
        return new Coord();
    }

    @Override
    public void buildNestedObject(Coord object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "X":
                reader.getTextContent().ifDouble(object::setX);
                break;
            case "Y":
                reader.getTextContent().ifDouble(object::setY);
                break;
            case "Z":
                reader.getTextContent().ifDouble(object::setZ);
                break;
        }
    }
}
