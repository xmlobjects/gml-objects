package org.xmlobjects.gml.adapter.valueobjects;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.adapter.basictypes.NilReasonAdapter;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.valueobjects.AbstractValue;
import org.xmlobjects.gml.model.valueobjects.Value;
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

public class ValueAdapter implements ObjectBuilder<Value>, ObjectSerializer<Value> {

    @Override
    public Value createObject(QName name) {
        return new Value();
    }

    @Override
    public void buildChildObject(Value object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        GMLObject child = reader.getObject(GMLObject.class);
        if (child instanceof AbstractValue)
            object.setValue((AbstractValue) child);
        else if (child instanceof AbstractGeometry)
            object.setGeometry((AbstractGeometry) child);
        else if (child instanceof NilReason)
            object.setNull((NilReason) child);
        else
            object.setGenericElement(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void writeChildElements(Value object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.isSetValue())
            writer.writeObject(object.getValue(), namespaces);
        else if (object.isSetGeometry())
            writer.writeObject(object.getGeometry(), namespaces);
        else if (object.isSetNull())
            writer.writeElementUsingSerializer(Element.of(SerializerHelper.getGMLBaseNamespace(namespaces), "Null"), object.getNull(), NilReasonAdapter.class, namespaces);
        else if (object.isSetGenericElement())
            writer.writeDOMElement(object.getGenericElement().getContent());
    }
}
