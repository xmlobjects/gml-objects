package org.xmlobjects.gml.builder.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.AbstractPropertyBuilder;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

import javax.xml.namespace.QName;

public class GeometryPropertyBuilder<T extends GeometryProperty> extends AbstractPropertyBuilder<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) throws ObjectBuildException {
        return (T) new GeometryProperty<>();
    }
}
