package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.basictypes.LanguageString;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.util.Properties;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

public class LanguageStringAdapter implements ObjectBuilder<LanguageString>, ObjectSerializer<LanguageString> {

    @Override
    public LanguageString createObject(QName name, Properties properties) {
        return new LanguageString();
    }

    @Override
    public void initializeObject(LanguageString object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getTextContent().ifPresent(object::setValue);
        attributes.getValue(XMLConstants.XML_NS_URI, "lang").ifPresent(object::setLanguage);
    }

    @Override
    public void initializeElement(Element element, LanguageString object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addTextContent(object.getValue());
        element.addAttribute(XMLConstants.XML_NS_URI, "lang", object.getLanguage());
    }
}
