package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurfacePatch;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractSurfacePatchBuilder<T extends AbstractSurfacePatch> implements ObjectBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
    }
}
