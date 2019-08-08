package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.BooleanOrNilReason;
import org.xmlobjects.gml.model.basictypes.BooleanOrNilReasonList;
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
import java.util.Objects;
import java.util.stream.Collectors;

public class BooleanOrNilReasonListAdapter implements ObjectBuilder<BooleanOrNilReasonList>, ObjectSerializer<BooleanOrNilReasonList> {

    @Override
    public BooleanOrNilReasonList createObject(QName name) {
        return new BooleanOrNilReasonList();
    }

    @Override
    public void initializeObject(BooleanOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        TextContent content = reader.getTextContent();
        for (String item : content.getAsList()) {
            TextContent value = TextContent.of(item);
            if (value.isBoolean())
                object.getValue().add(new BooleanOrNilReason(value.getAsBoolean()));
            else
                object.getValue().add(new BooleanOrNilReason(new NilReason(item)));
        }
    }

    @Override
    public void initializeElement(Element element, BooleanOrNilReasonList object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(TextContent.ofList(object.getValue().stream()
                .filter(Objects::nonNull)
                .map(v -> {
                    if (v.isSetValue())
                        return v.getValue().toString();
                    else if (v.isSetNilReason())
                        return v.getNilReason().getValue();
                    else
                        return null;
                }).collect(Collectors.toList())));
    }
}
