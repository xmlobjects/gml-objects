package org.xmlobjects.gml.builder.deprecatedTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.model.deprecatedTypes.StringOrRef;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public class StringOrRefBuilder implements ObjectBuilder<StringOrRef> {

    @Override
    public StringOrRef createObject(QName name) {
        return new StringOrRef();
    }

    @Override
    public void initializeObject(StringOrRef object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        AttributesBuilder.buildAssociationAttributes(object, attributes);
    }
}
