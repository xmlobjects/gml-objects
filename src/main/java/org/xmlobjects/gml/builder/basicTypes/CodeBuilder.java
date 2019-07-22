package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.Code;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class CodeBuilder implements ObjectBuilder<Code> {

    @Override
    public Code createObject(QName name) {
        return new Code();
    }

    @Override
    public void initializeObject(Code object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }
}
