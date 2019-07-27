package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class NilReasonBuilder implements ObjectBuilder<NilReason>, ObjectSerializer<NilReason> {

    @Override
    public NilReason createObject(QName name) {
        return new NilReason();
    }

    @Override
    public void initializeObject(NilReason object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
    }

    @Override
    public void initializeElement(Element element, NilReason object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(object.getValue());
    }
}
