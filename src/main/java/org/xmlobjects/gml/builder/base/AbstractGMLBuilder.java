package org.xmlobjects.gml.builder.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.basicTypes.CodeBuilder;
import org.xmlobjects.gml.builder.basicTypes.CodeWithAuthorityBuilder;
import org.xmlobjects.gml.builder.deprecatedTypes.MetaDataPropertyBuilder;
import org.xmlobjects.gml.builder.deprecatedTypes.StringOrRefBuilder;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.common.Constants;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractGMLBuilder<T extends AbstractGML> implements ObjectBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        attributes.getValue(Constants.GML_3_1_NAMESPACE_URI, "id").ifPresent(object::setId);
        attributes.getValue(Constants.GML_3_2_NAMESPACE_URI, "id").ifPresent(object::setId);
    }

    @Override
    public void buildNestedObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
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
}
