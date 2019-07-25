package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.common.BuilderHelper;
import org.xmlobjects.gml.builder.geometry.AbstractGeometryBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.AbstractGeometricAggregate;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.xml.Attributes;

import javax.xml.namespace.QName;

public abstract class AbstractGeometricAggregateBuilder<T extends AbstractGeometricAggregate> extends AbstractGeometryBuilder<T> {

    @Override
    public void initializeObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        BuilderHelper.buildAggregationAttributes(object, attributes);
    }
}
