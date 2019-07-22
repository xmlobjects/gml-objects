package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.DoubleOrNilReason;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class DoubleOrNilReasonBuilder implements ObjectBuilder<DoubleOrNilReason> {

    @Override
    public DoubleOrNilReason createObject(QName name) {
        return new DoubleOrNilReason();
    }

    @Override
    public void initializeObject(DoubleOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        if (content.isDouble())
            object.setDouble(content.getAsDouble());
        else
            object.setNilReason(new NilReason(content.get()));
    }
}
