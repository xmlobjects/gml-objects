package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class GeometryPropertyAdapter<T extends GeometryProperty> extends AbstractPropertyAdapter<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name, Properties properties) throws ObjectBuildException {
        return (T) new GeometryProperty<>();
    }
}
