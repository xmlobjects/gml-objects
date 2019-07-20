package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.BooleanOrNilReason;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class BooleanOrNilReasonBuilder implements ObjectBuilder<BooleanOrNilReason> {

    @Override
    public BooleanOrNilReason createObject(QName name) {
        return new BooleanOrNilReason();
    }

    @Override
    public void initializeObject(BooleanOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        if (content.isBoolean())
            object.setBoolean(content.getAsBoolean());
        else
            object.setNilReason(new NilReason(content.get()));
    }

    @Override
    public void buildNestedObject(BooleanOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }
}
