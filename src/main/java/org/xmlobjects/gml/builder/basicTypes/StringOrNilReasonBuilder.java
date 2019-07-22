package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.gml.model.basicTypes.StringOrNilReason;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class StringOrNilReasonBuilder implements ObjectBuilder<StringOrNilReason> {

    @Override
    public StringOrNilReason createObject(QName name) {
        return new StringOrNilReason();
    }

    @Override
    public void initializeObject(StringOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        TextContent content = reader.getTextContent();
        NilReason nilReason = new NilReason(content.get());
        if (nilReason.getValue() != null)
            object.setNilReason(nilReason);
        else
            object.setString(content.get());
    }
}
