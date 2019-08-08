package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.valueobjects.BooleanValue;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Boolean", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "Boolean", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class BooleanValueAdapter implements ObjectBuilder<BooleanValue>, ObjectSerializer<BooleanValue> {

    @Override
    public BooleanValue createObject(QName name) {
        return new BooleanValue();
    }

    @Override
    public void initializeObject(BooleanValue object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifBoolean(object::setValue);
        if (!object.isSetValue())
            attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    @Override
    public Element createElement(BooleanValue object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Boolean");
    }

    @Override
    public void initializeElement(Element element, BooleanValue object, Namespaces namespaces, XMLWriter writer) {
        if (object.isSetValue())
            element.addTextContent(TextContent.ofBoolean(object.getValue()));
        else if (object.isSetNilReason() && GMLObjects.GML_3_2_NAMESPACE.equals(SerializerHelper.getGMLBaseNamespace(namespaces))) {
            element.addAttribute("nilReason", object.getNilReason().getValue());
            element.addAttribute(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "nil", "true");
        }
    }
}
