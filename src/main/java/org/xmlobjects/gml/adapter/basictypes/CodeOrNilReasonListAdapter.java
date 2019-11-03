package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.CodeOrNilReasonList;
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

public class CodeOrNilReasonListAdapter implements ObjectBuilder<CodeOrNilReasonList>, ObjectSerializer<CodeOrNilReasonList> {

    @Override
    public CodeOrNilReasonList createObject(QName name) throws ObjectBuildException {
        return new CodeOrNilReasonList();
    }

    @Override
    public void initializeObject(CodeOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(NameOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void initializeElement(Element element, CodeOrNilReasonList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(NameOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
        element.addAttribute("codeSpace", object.getCodeSpace());
    }
}
