package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.util.GMLConstants;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.valueobjects.ValueArray;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "ValueArray", namespaceURI = GMLConstants.GML_3_2_NAMESPACE),
        @XMLElement(name = "ValueArray", namespaceURI = GMLConstants.GML_3_1_NAMESPACE)
})
public class ValueArrayAdapter extends AbstractCompositeValueAdapter<ValueArray> {

    @Override
    public ValueArray createObject(QName name) {
        return new ValueArray();
    }

    @Override
    public void initializeObject(ValueArray object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        BuilderHelper.buildReferenceSystem(object, attributes);
    }

    @Override
    public Element createElement(ValueArray object, Namespaces namespaces) {
        return Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "ValueArray");
    }

    @Override
    public void initializeElement(Element element, ValueArray object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        SerializerHelper.serializeReferenceSystem(element, object, namespaces);
    }
}
