package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.BooleanOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.BooleanValueList;
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
        @XMLElement(name = "BooleanList", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "BooleanList", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class BooleanValueListAdapter implements ObjectBuilder<BooleanValueList>, ObjectSerializer<BooleanValueList> {

    @Override
    public BooleanValueList createObject(QName name, Properties properties) {
        return new BooleanValueList();
    }

    @Override
    public void initializeObject(BooleanValueList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(BooleanOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BooleanValueList object, Namespaces namespaces, Properties properties) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "BooleanList");
    }

    @Override
    public void initializeElement(Element element, BooleanValueList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(BooleanOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
