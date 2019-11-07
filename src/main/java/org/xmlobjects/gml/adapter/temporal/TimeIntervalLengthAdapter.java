package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.temporal.TimeIntervalLength;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public class TimeIntervalLengthAdapter implements ObjectBuilder<TimeIntervalLength>, ObjectSerializer<TimeIntervalLength> {

    @Override
    public TimeIntervalLength createObject(QName name) throws ObjectBuildException {
        return new TimeIntervalLength();
    }

    @Override
    public void initializeObject(TimeIntervalLength object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDouble(object::setValue);
        attributes.getValue("unit").ifPresent(object::setUnit);
        attributes.getValue("radix").ifInteger(object::setRadix);
        attributes.getValue("factor").ifInteger(object::setFactor);
    }

    @Override
    public void initializeElement(Element element, TimeIntervalLength object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(TextContent.ofDouble(object.getValue()));
        element.addAttribute("unit", object.getUnit());
        element.addAttribute("radix", TextContent.ofInteger(object.getRadix()));
        element.addAttribute("factor", TextContent.ofInteger(object.getFactor()));
    }
}
