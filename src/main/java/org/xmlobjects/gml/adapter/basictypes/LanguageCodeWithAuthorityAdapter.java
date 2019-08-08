package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
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

public class LanguageCodeWithAuthorityAdapter implements ObjectBuilder<CodeWithAuthority>, ObjectSerializer<CodeWithAuthority> {

    @Override
    public CodeWithAuthority createObject(QName name) {
        return new CodeWithAuthority();
    }

    @Override
    public void initializeObject(CodeWithAuthority object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(LanguageCodeAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public void initializeElement(Element element, CodeWithAuthority object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(LanguageCodeAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
