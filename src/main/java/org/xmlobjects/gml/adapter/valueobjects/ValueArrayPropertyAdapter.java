package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.base.AbstractArrayPropertyAdapter;
import org.xmlobjects.gml.model.valueobjects.Value;
import org.xmlobjects.gml.model.valueobjects.ValueArrayProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class ValueArrayPropertyAdapter extends AbstractArrayPropertyAdapter<ValueArrayProperty> {

    @Override
    public ValueArrayProperty createObject(QName name) {
        return new ValueArrayProperty();
    }

    @Override
    public void initializeObject(ValueArrayProperty object, QName name, Attributes attributes, XMLReader reader) {
        BuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(ValueArrayProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        Value child = new Value();
        reader.getOrCreateBuilder(ValueAdapter.class).buildChildObject(child, name, attributes, reader);
        object.getObjects().add(child);
    }

    @Override
    public void initializeElement(Element element, ValueArrayProperty object, Namespaces namespaces, XMLWriter writer) {
        SerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(ValueArrayProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        for (Value child : object.getObjects())
            writer.getOrCreateSerializer(ValueAdapter.class).writeChildElements(child, namespaces, writer);
    }
}
