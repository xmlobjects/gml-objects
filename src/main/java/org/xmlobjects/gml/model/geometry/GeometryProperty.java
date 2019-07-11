package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class GeometryProperty<T extends AbstractGeometry> extends AbstractProperty<T> {

    public GeometryProperty() {
    }

    public GeometryProperty(T object) {
        super(object);
    }

    public GeometryProperty(String href) {
        super(href);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractGeometry.class;
    }
}
