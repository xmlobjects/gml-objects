package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.ArrayProperty;

import java.util.List;

public class SurfacePatchArrayProperty<T extends AbstractSurfacePatch> extends ArrayProperty<T> {

    public SurfacePatchArrayProperty() {
    }

    public SurfacePatchArrayProperty(List<T> objects) {
        super(objects);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractSurfacePatch.class;
    }
}