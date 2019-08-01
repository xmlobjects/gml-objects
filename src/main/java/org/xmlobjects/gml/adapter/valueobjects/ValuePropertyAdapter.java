package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.valueobjects.Value;
import org.xmlobjects.gml.model.valueobjects.ValueProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class ValuePropertyAdapter extends AbstractPropertyAdapter<ValueProperty> {

    @Override
    public ValueProperty createObject(QName name) {
        return new ValueProperty();
    }

    @Override
    public void buildChildObject(ValueProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        Value value = new Value();
        reader.getOrCreateBuilder(ValueAdapter.class).buildChildObject(value, name, attributes, reader);
        object.setObject(value);
    }

    @Override
    public void writeChildElements(ValueProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null)
            writer.getOrCreateSerializer(ValueAdapter.class).writeChildElements(object.getObject(), namespaces, writer);
    }
}
