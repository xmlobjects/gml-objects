package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.valueobjects.Count;
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
        @XMLElement(name = "Count", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "Count", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class CountAdapter implements ObjectBuilder<Count>, ObjectSerializer<Count> {

    @Override
    public Count createObject(QName name) {
        return new Count();
    }

    @Override
    public void initializeObject(Count object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifInteger(object::setValue);
        if (!object.isSetValue())
            attributes.getValue("nilReason").ifPresent(v -> object.setNilReason(new NilReason(v)));
    }

    @Override
    public Element createElement(Count object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Count");
    }

    @Override
    public void initializeElement(Element element, Count object, Namespaces namespaces, XMLWriter writer) {
        if (object.isSetValue())
            element.addTextContent(TextContent.ofInteger(object.getValue()));
        else if (object.isSetNilReason() && GMLObjects.GML_3_2_NAMESPACE.equals(SerializerHelper.getGMLBaseNamespace(namespaces))) {
            element.addAttribute("nilReason", object.getNilReason().getValue());
            element.addAttribute(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "nil", "true");
        }
    }
}
