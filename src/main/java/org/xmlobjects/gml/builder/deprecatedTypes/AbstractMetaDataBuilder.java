package org.xmlobjects.gml.builder.deprecatedTypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.deprecatedTypes.AbstractMetaData;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractMetaDataBuilder<T extends AbstractMetaData> implements ObjectBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue(GMLConstants.GML_3_1_NAMESPACE_URI, "id").ifPresent(object::setId);
        attributes.getValue(GMLConstants.GML_3_2_NAMESPACE_URI, "id").ifPresent(object::setId);
    }
}
