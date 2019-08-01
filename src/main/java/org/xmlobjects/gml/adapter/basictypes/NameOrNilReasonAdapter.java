package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.NameOrNilReason;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.XMLPatterns;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class NameOrNilReasonAdapter implements ObjectBuilder<NameOrNilReason>, ObjectSerializer<NameOrNilReason> {

    @Override
    public NameOrNilReason createObject(QName name) {
        return new NameOrNilReason();
    }

    @Override
    public void initializeObject(NameOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        TextContent content = reader.getTextContent();
        if (XMLPatterns.NAME.matcher(content.get()).matches())
            object.setValue(content.get());
        else
            object.setNilReason(new NilReason(content.get()));
    }

    @Override
    public void initializeElement(Element element, NameOrNilReason object, Namespaces namespaces, XMLWriter writer) {
        if (object.isSetValue())
            element.addTextContent(object.getValue());
        else if (object.isSetNilReason())
            element.addTextContent(object.getNilReason().getValue());
    }
}
