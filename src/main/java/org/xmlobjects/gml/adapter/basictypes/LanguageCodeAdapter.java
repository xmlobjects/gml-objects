package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class LanguageCodeAdapter implements ObjectBuilder<Code>, ObjectSerializer<Code> {

    @Override
    public Code createObject(QName name) {
        return new Code();
    }

    @Override
    public void initializeObject(Code object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(LanguageStringAdapter.class).initializeObject(object, name, attributes, reader);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void initializeElement(Element element, Code object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(LanguageStringAdapter.class).initializeElement(element, object, namespaces, writer);
        element.addAttribute("codeSpace", object.getCodeSpace());
    }
}
