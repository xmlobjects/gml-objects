package org.xmlobjects.gml.builder.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.basicTypes.CodeBuilder;
import org.xmlobjects.gml.builder.basicTypes.CodeWithAuthorityBuilder;
import org.xmlobjects.gml.builder.common.SerializerHelper;
import org.xmlobjects.gml.builder.deprecatedTypes.MetaDataPropertyBuilder;
import org.xmlobjects.gml.builder.deprecatedTypes.StringOrRefBuilder;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basicTypes.Code;
import org.xmlobjects.gml.model.deprecatedTypes.MetaDataProperty;
import org.xmlobjects.gml.util.GMLConstants;
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

public abstract class AbstractGMLBuilder<T extends AbstractGML> implements ObjectBuilder<T>, ObjectSerializer<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue(GMLConstants.GML_3_1_NAMESPACE_URI, "id").ifPresent(object::setId);
        attributes.getValue(GMLConstants.GML_3_2_NAMESPACE_URI, "id").ifPresent(object::setId);
    }

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        switch (name.getLocalPart()) {
            case "description":
                object.setDescription(reader.getObjectUsingBuilder(StringOrRefBuilder.class));
                break;
            case "descriptionReference":
                object.setDescriptionReference(reader.getObjectUsingBuilder(ReferenceBuilder.class));
                break;
            case "identifier":
                object.setIdentifier(reader.getObjectUsingBuilder(CodeWithAuthorityBuilder.class));
                break;
            case "name":
                object.getNames().add(reader.getObjectUsingBuilder(CodeBuilder.class));
                break;
            case "metaDataProperty":
                object.getMetaDataProperties().add(reader.getObjectUsingBuilder(MetaDataPropertyBuilder.class));
                break;
        }
    }

    @Override
    public void initializeElement(Element element, T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        element.addAttribute(SerializerHelper.getTargetNamespace(namespaces), "id", object.getId());
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String targetNamespace = SerializerHelper.getTargetNamespace(namespaces);

        for (MetaDataProperty property : object.getMetaDataProperties())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "metaDataProperty"), property, MetaDataPropertyBuilder.class, namespaces);

        if (object.getDescription() != null)
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "description"), object.getDescription(), StringOrRefBuilder.class, namespaces);

        if (GMLConstants.GML_3_2_NAMESPACE_URI.equals(targetNamespace)) {
            if (object.getDescriptionReference() != null)
                writer.writeElementUsingSerializer(Element.of(targetNamespace, "descriptionReference"), object.getDescriptionReference(), ReferenceBuilder.class, namespaces);

            if (object.getIdentifier() != null)
                writer.writeElementUsingSerializer(Element.of(targetNamespace, "identifier"), object.getIdentifier(), CodeWithAuthorityBuilder.class, namespaces);
        }

        for (Code name : object.getNames())
            writer.writeElementUsingSerializer(Element.of(targetNamespace, "name"), name, CodeBuilder.class, namespaces);
    }
}
