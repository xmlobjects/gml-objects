package org.xmlobjects.gml.adapter.base;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.LanguageStringAuxAdapter;
import org.xmlobjects.gml.adapter.deprecated.StringOrRefAdapter;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
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

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "description", namespaceURI = GMLObjects.GML_3_3_XBT_NAMESPACE),
        @XMLElement(name = "description", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "description", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class DescriptionAdapter implements ObjectBuilder<StringOrRef>, ObjectSerializer<StringOrRef> {

    @Override
    public StringOrRef createObject(QName name) {
        return new StringOrRef();
    }

    @Override
    public void initializeObject(StringOrRef object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(GMLObjects.GML_3_3_XBT_NAMESPACE.equals(name.getNamespaceURI()) ?
                LanguageStringAuxAdapter.class : StringOrRefAdapter.class)
                .initializeObject(object, name, attributes, reader);
    }
    @Override
    public Element createElement(StringOrRef object, Namespaces namespaces) {
        return object.getLanguage() != null && namespaces.contains(GMLObjects.GML_3_3_XBT_NAMESPACE) ?
                Element.of(GMLObjects.GML_3_3_XBT_NAMESPACE, "description") :
                Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "description");
    }

    @Override
    public void initializeElement(Element element, StringOrRef object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(GMLObjects.GML_3_3_XBT_NAMESPACE.equals(element.getName().getNamespaceURI()) ?
                LanguageStringAuxAdapter.class : StringOrRefAdapter.class)
                .initializeElement(element, object, namespaces, writer);
    }
}
