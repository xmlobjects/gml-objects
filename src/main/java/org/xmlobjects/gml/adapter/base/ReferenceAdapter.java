package org.xmlobjects.gml.adapter.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.model.base.Reference;
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

public class ReferenceAdapter implements ObjectBuilder<Reference>, ObjectSerializer<Reference> {

    @Override
    public Reference createObject(QName name) throws ObjectBuildException {
        return new Reference();
    }

    @Override
    public void initializeObject(Reference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        GMLBuilderHelper.buildAssociationAttributes(object, attributes);
        GMLBuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @Override
    public void initializeElement(Element element, Reference object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        GMLSerializerHelper.serializeAssociationAttributes(element, object, namespaces);
        GMLSerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }
}
