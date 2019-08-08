package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.GMLObjects;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.IntegerOrNilReasonListAdapter;
import org.xmlobjects.gml.model.valueobjects.CountExtent;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "CountExtent", namespaceURI = GMLObjects.GML_3_2_NAMESPACE),
        @XMLElement(name = "CountExtent", namespaceURI = GMLObjects.GML_3_1_NAMESPACE)
})
public class CountExtentAdapter implements ObjectBuilder<CountExtent>, ObjectSerializer<CountExtent> {

    @Override
    public CountExtent createObject(QName name) {
        return new CountExtent();
    }

    @Override
    public void initializeObject(CountExtent object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        reader.getOrCreateBuilder(IntegerOrNilReasonListAdapter.class).initializeObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CountExtent object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "CountExtent");
    }

    @Override
    public void initializeElement(Element element, CountExtent object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.getOrCreateSerializer(IntegerOrNilReasonListAdapter.class).initializeElement(element, object, namespaces, writer);
    }
}
