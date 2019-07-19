package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.CodeWithAuthority;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class CodeWithAuthorityBuilder implements ObjectBuilder<CodeWithAuthority> {

    @Override
    public CodeWithAuthority createObject(QName name) {
        return new CodeWithAuthority();
    }

    @Override
    public void initializeObject(CodeWithAuthority object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void buildNestedObject(CodeWithAuthority object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }
}
