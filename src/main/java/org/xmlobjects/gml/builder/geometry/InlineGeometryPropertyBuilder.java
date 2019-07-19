package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.InlineGeometryProperty;
import org.xmlobjects.stream.BuildResult;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class InlineGeometryPropertyBuilder<T extends InlineGeometryProperty> implements ObjectBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void buildNestedObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        BuildResult<GMLObject> result = reader.getObject(object.getTargetType());
        if (result.isSetObject())
            object.setObject(result.getObject());
    }
}
