package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.common.BuilderHelper;
import org.xmlobjects.gml.adapter.common.SerializerHelper;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class DirectPositionListAdapter implements ObjectBuilder<DirectPositionList>, ObjectSerializer<DirectPositionList> {

    @Override
    public DirectPositionList createObject(QName name) {
        return new DirectPositionList();
    }

    @Override
    public void initializeObject(DirectPositionList object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifDoubleList(object::setValue);
        attributes.getValue("count").ifInteger(object::setCount);
        BuilderHelper.buildSRSReference(object, attributes);
    }

    @Override
    public void initializeElement(Element element, DirectPositionList object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(TextContent.ofDoubleList(object.getValue()));
        element.addAttribute("count", TextContent.ofInteger(object.getCount()));
        SerializerHelper.serializeSRSReference(element, object, namespaces);
    }
}
