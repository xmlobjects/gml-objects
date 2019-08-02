package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "Null", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "Null", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class NilReasonAdapter implements ObjectBuilder<NilReason>, ObjectSerializer<NilReason> {

    @Override
    public NilReason createObject(QName name) {
        return new NilReason();
    }

    @Override
    public void initializeObject(NilReason object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
    }

    @Override
    public Element createElement(NilReason object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Null");
    }

    @Override
    public void initializeElement(Element element, NilReason object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(object.getValue());
    }
}
