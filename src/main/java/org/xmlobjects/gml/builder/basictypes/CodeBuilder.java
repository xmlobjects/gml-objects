package org.xmlobjects.gml.builder.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class CodeBuilder implements ObjectBuilder<Code>, ObjectSerializer<Code> {

    @Override
    public Code createObject(QName name) {
        return new Code();
    }

    @Override
    public void initializeObject(Code object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void initializeElement(Element element, Code object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(object.getValue());
        element.addAttribute("codeSpace", object.getCodeSpace());
    }
}
