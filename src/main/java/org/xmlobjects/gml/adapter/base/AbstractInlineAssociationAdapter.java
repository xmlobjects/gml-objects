package org.xmlobjects.gml.adapter.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineAssociation;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public abstract class AbstractInlineAssociationAdapter<T extends AbstractInlineAssociation> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        object.setObject((GMLObject) reader.getObject(object.getTargetType()));
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null)
            writer.writeObject(object.getObject(), namespaces);
    }
}
