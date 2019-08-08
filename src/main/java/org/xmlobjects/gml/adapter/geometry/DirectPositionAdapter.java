package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class DirectPositionAdapter implements ObjectBuilder<DirectPosition>, ObjectSerializer<DirectPosition> {

    @Override
    public DirectPosition createObject(QName name, Properties properties) {
        return new DirectPosition();
    }

    @Override
    public void initializeObject(DirectPosition object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        BuilderHelper.buildSRSReference(object, attributes);
    }

    @Override
    public void initializeElement(Element element, DirectPosition object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(TextContent.ofDoubleList(object.getValue()));
        SerializerHelper.serializeSRSReference(element, object, namespaces);
    }
}
