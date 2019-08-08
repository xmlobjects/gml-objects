package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.BuilderHelper;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.gml.model.valueobjects.CompositeValue;
import org.xmlobjects.gml.model.valueobjects.ValueProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractCompositeValueAdapter<T extends CompositeValue> extends AbstractGMLAdapter<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (BuilderHelper.isGMLNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "valueComponent":
                    object.getValueComponent().add(reader.getObjectUsingBuilder(ValuePropertyAdapter.class));
                    break;
                case "valueComponents":
                    object.setValueComponents(reader.getObjectUsingBuilder(ValueArrayPropertyAdapter.class));
                    break;
                default:
                    super.buildChildObject(object, name, attributes, reader);
                    break;
            }
        }
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        SerializerHelper.serializeAggregationAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String baseNamespace = SerializerHelper.getGMLBaseNamespace(namespaces);

        for (ValueProperty property : object.getValueComponent())
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "valueComponent"), property, ValuePropertyAdapter.class, namespaces);

        if (object.getValueComponents() != null)
            writer.writeElementUsingSerializer(Element.of(baseNamespace, "valueComponents"), object.getValueComponents(), ValueArrayPropertyAdapter.class, namespaces);
    }
}
