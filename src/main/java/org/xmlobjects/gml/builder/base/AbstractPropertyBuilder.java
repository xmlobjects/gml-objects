package org.xmlobjects.gml.builder.base;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractProperty;
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractPropertyBuilder<T extends AbstractProperty> implements ObjectBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuilderHelper.buildAssociationAttributes(object, attributes);
        BuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<GMLObject> result = reader.getObject(object.getTargetType());
        if (result.isSetObject())
            object.setObject(result.getObject());
    }
}
