package org.xmlobjects.gml.builder.base;

import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class ReferenceBuilder implements ObjectBuilder<Reference>, ObjectSerializer<Reference> {

    @Override
    public Reference createObject(QName name) {
        return new Reference();
    }

    @Override
    public void initializeObject(Reference object, QName name, Attributes attributes, XMLReader reader) {
        BuilderHelper.buildAssociationAttributes(object, attributes);
        BuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @Override
    public void initializeElement(Element element, Reference object, Namespaces namespaces, XMLWriter writer) {
        SerializerHelper.serializeAssociationAttributes(element, object, namespaces);
        SerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }
}
