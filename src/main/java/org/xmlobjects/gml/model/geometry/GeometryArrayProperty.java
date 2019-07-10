package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.ArrayProperty;

import java.util.List;

public class GeometryArrayProperty<T extends AbstractGeometry> extends ArrayProperty<T> {

    public GeometryArrayProperty() {
    }

    public GeometryArrayProperty(List<T> objects) {
        super(objects);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractGeometry.class;
    }
}
