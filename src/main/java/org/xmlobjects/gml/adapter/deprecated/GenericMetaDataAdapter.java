package org.xmlobjects.gml.adapter.deprecated;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.deprecated.GenericMetaData;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "GenericMetaData", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "GenericMetaData", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class GenericMetaDataAdapter extends AbstractMetaDataAdapter<GenericMetaData> {

    @Override
    public GenericMetaData createObject(QName name) {
        return new GenericMetaData();
    }

    @Override
    public void initializeObject(GenericMetaData object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        object.setAnyContent(reader.getMixedContent());
    }

    @Override
    public Element createElement(GenericMetaData object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "GenericMetaData");
    }

    @Override
    public void writeChildElements(GenericMetaData object, Namespaces namespaces, XMLWriter writer) throws XMLWriteException {
        if (object.getAnyContent() != null)
            writer.writeMixedContent(object.getAnyContent());
    }
}
