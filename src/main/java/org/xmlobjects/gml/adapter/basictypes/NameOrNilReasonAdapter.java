package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.NameOrNilReason;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.basictypes.NilReasonEnumeration;
import org.xmlobjects.gml.util.GMLPatterns;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.xml.XMLPatterns;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class NameOrNilReasonAdapter implements ObjectBuilder<NameOrNilReason>, ObjectSerializer<NameOrNilReason> {

    @Override
    public NameOrNilReason createObject(QName name) throws ObjectBuildException {
        return new NameOrNilReason();
    }

    @Override
    public void initializeObject(NameOrNilReason object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        String content = reader.getTextContent().get();
        if (NilReasonEnumeration.fromValue(content) != null
                || GMLPatterns.OTHER_VALUE.matcher(content).matches()
                || !XMLPatterns.NAME.matcher(content).matches())
            object.setNilReason(new NilReason(content));
        else
            object.setValue(content);
    }

    @Override
    public void initializeElement(Element element, NameOrNilReason object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetValue())
            element.addTextContent(object.getValue());
        else if (object.isSetNilReason())
            element.addTextContent(object.getNilReason().getValue());
    }
}
