package org.xmlobjects.gml.adapter.deprecated;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.SerializerHelper;
import org.xmlobjects.gml.model.deprecated.AbstractMetaData;
import org.xmlobjects.gml.GMLObjects;
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

public abstract class AbstractMetaDataAdapter<T extends AbstractMetaData> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue(GMLObjects.GML_3_1_NAMESPACE, "id").ifPresent(object::setId);
        attributes.getValue(GMLObjects.GML_3_2_NAMESPACE, "id").ifPresent(object::setId);
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addAttribute(SerializerHelper.getGMLBaseNamespace(namespaces), "id", object.getId());
    }
}
