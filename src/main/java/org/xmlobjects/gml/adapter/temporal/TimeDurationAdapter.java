package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.temporal.TimeDuration;
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

public class TimeDurationAdapter implements ObjectBuilder<TimeDuration>, ObjectSerializer<TimeDuration> {

    @Override
    public TimeDuration createObject(QName name) throws ObjectBuildException {
        return new TimeDuration();
    }

    @Override
    public void initializeObject(TimeDuration object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifDuration(object::setValue);
    }

    @Override
    public void initializeElement(Element element, TimeDuration object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(TextContent.ofDuration(object.getValue()));
    }
}
