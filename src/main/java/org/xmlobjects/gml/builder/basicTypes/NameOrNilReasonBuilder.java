package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.NameOrNilReason;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.util.XMLPatterns;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class NameOrNilReasonBuilder implements ObjectBuilder<NameOrNilReason> {

    @Override
    public NameOrNilReason createObject(QName name) {
        return new NameOrNilReason();
    }

    @Override
    public void initializeObject(NameOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        if (XMLPatterns.NAME.matcher(content.get()).matches())
            object.setName(content.get());
        else
            object.setNilReason(new NilReason(content.get()));
    }

    @Override
    public void buildNestedObject(NameOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }
}
