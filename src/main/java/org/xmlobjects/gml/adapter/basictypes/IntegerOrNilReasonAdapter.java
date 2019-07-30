package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.IntegerOrNilReason;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class IntegerOrNilReasonAdapter implements ObjectBuilder<IntegerOrNilReason>, ObjectSerializer<IntegerOrNilReason> {

    @Override
    public IntegerOrNilReason createObject(QName name) {
        return new IntegerOrNilReason();
    }

    @Override
    public void initializeObject(IntegerOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        TextContent content = reader.getTextContent();
        if (content.isInteger())
            object.setInteger(content.getAsInteger());
        else
            object.setNilReason(new NilReason(content.get()));
    }

    @Override
    public void initializeElement(Element element, IntegerOrNilReason object, Namespaces namespaces, XMLWriter writer) {
        if (object.isSetValue())
            element.addTextContent(TextContent.ofInteger(object.getValue()));
        else if (object.isSetNilReason())
            element.addTextContent(object.getNilReason().getValue());
    }
}
