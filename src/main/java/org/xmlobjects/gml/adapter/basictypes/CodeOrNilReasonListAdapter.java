package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.CodeOrNilReasonList;
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
import java.util.Objects;
import java.util.stream.Collectors;

public class CodeOrNilReasonListAdapter implements ObjectBuilder<CodeOrNilReasonList>, ObjectSerializer<CodeOrNilReasonList> {

    @Override
    public CodeOrNilReasonList createObject(QName name) {
        return new CodeOrNilReasonList();
    }

    @Override
    public void initializeObject(CodeOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        TextContent content = reader.getTextContent();
        for (String item : content.getAsList()) {
            if (XMLPatterns.NAME.matcher(item).matches())
                object.getValue().add(new NameOrNilReason(item));
            else
                object.getValue().add(new NameOrNilReason(new NilReason(item)));
        }

        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }

    @Override
    public void initializeElement(Element element, CodeOrNilReasonList object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(TextContent.ofList(object.getValue().stream()
                .filter(Objects::nonNull)
                .map(v -> {
                    if (v.isSetValue())
                        return v.getValue();
                    else if (v.isSetNilReason())
                        return v.getNilReason().getValue();
                    else
                        return null;
                }).collect(Collectors.toList())));

        element.addAttribute("codeSpace", object.getCodeSpace());
    }
}
