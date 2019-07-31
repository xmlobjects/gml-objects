package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.CodeOrNilReasonList;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class CodeOrNilReasonListAdapter implements ObjectBuilder<CodeOrNilReasonList>, ObjectSerializer<CodeOrNilReasonList> {
    private final NameOrNilReasonListAdapter delegate = new NameOrNilReasonListAdapter();

    @Override
    public CodeOrNilReasonList createObject(QName name) {
        return new CodeOrNilReasonList();
    }

    @Override
    public void initializeObject(CodeOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        delegate.initializeObject(object, name, attributes, reader);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void initializeElement(Element element, CodeOrNilReasonList object, Namespaces namespaces, XMLWriter writer) {
        delegate.initializeElement(element, object, namespaces, writer);
        element.addAttribute("codeSpace", object.getCodeSpace());
    }
}
