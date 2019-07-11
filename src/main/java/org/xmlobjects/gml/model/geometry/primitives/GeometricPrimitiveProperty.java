package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class GeometricPrimitiveProperty<T extends AbstractGeometricPrimitive> extends GeometryProperty<T> {

    public GeometricPrimitiveProperty() {
    }

    public GeometricPrimitiveProperty(T primitive) {
        super(primitive);
    }

    public GeometricPrimitiveProperty(String href) {
        super(href);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractGeometricPrimitive.class;
    }
}
