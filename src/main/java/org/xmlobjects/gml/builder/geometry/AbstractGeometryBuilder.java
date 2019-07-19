package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.AbstractGMLBuilder;
import org.xmlobjects.gml.builder.common.AttributesBuilder;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractGeometryBuilder<T extends AbstractGeometry> extends AbstractGMLBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        AttributesBuilder.buildSRSReference(object, attributes);
    }
}
