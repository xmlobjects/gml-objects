package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.IntegerOrNilReason;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class IntegerOrNilReasonBuilder implements ObjectBuilder<IntegerOrNilReason> {

    @Override
    public IntegerOrNilReason createObject(QName name) {
        return new IntegerOrNilReason();
    }

    @Override
    public void initializeObject(IntegerOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        if (content.isInteger())
            object.setInteger(content.getAsInteger());
        else
            object.setNilReason(new NilReason(content.get()));
    }
}
