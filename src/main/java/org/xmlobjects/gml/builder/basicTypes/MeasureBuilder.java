package org.xmlobjects.gml.builder.basicTypes;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basicTypes.Measure;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class MeasureBuilder<T extends Measure> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new Measure();
    }

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws XMLReadException {
        reader.getTextContent().ifDouble(object::setValue);
        attributes.getValue("uom").ifPresent(object::setUom);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) {
        element.addTextContent(TextContent.ofDouble(object.getValue()));
        element.addAttribute("uom", object.getUom());
    }
}
