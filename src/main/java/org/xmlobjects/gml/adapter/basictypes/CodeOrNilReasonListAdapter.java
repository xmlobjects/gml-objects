package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.gml.model.basictypes.CodeOrNilReasonList;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class CodeOrNilReasonListAdapter<T extends CodeOrNilReasonList> extends NameOrNilReasonListAdapter<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new CodeOrNilReasonList();
    }

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) {
        super.initializeElement(element, object, namespaces, writer);
        element.addAttribute("codeSpace", object.getCodeSpace());
    }
}
