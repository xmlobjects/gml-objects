package org.xmlobjects.gml.builder.deprecatedTypes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.deprecatedTypes.GenericMetaData;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "GenericMetaData", namespaceURI = GMLConstants.GML_3_2_NAMESPACE_URI),
        @XMLElement(name = "GenericMetaData", namespaceURI = GMLConstants.GML_3_1_NAMESPACE_URI)
})
public class GenericMetaDataBuilder extends AbstractMetaDataBuilder<GenericMetaData> {

    @Override
    public GenericMetaData createObject(QName name) {
        return new GenericMetaData();
    }

    @Override
    public void initializeObject(GenericMetaData object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        object.setAnyContent(reader.getMixedContent());
    }
}
