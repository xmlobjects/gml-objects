package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.Vector;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class VectorBuilder implements ObjectBuilder<Vector>, ObjectSerializer<Vector> {

    @Override
    public Vector createObject(QName name) {
        return new Vector();
    }

    @Override
    public void initializeObject(Vector object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        BuilderHelper.buildSRSReference(object, attributes);
    }

    @Override
    public void initializeElement(Element element, Vector object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(TextContent.ofDoubleList(object.getValue()));
        SerializerHelper.serializeSRSReference(element, object, namespaces);
    }
}
