package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.CodeOrNilReasonList;
import org.xmlobjects.gml.model.basicTypes.NameOrNilReason;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.util.XMLPatterns;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class CodeOrNilReasonListBuilder implements ObjectBuilder<CodeOrNilReasonList> {

    @Override
    public CodeOrNilReasonList createObject(QName name) {
        return new CodeOrNilReasonList();
    }

    @Override
    public void initializeObject(CodeOrNilReasonList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        for (String item : content.getAsList()) {
            if (XMLPatterns.NAME.matcher(item).matches())
                object.getValue().add(new NameOrNilReason(item));
            else
                object.getValue().add(new NameOrNilReason(new NilReason(item)));
        }

        attributes.getValue("codeSpace").ifPresent(object::setCodeSpace);
    }
}
