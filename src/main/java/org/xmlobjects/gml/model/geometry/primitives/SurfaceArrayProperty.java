package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;

import java.util.List;

public class SurfaceArrayProperty extends GeometryArrayProperty<AbstractSurface> {

    public SurfaceArrayProperty() {
    }

    public SurfaceArrayProperty(List<AbstractSurface> surfaces) {
        super(surfaces);
    }

    @Override
    public Class<AbstractSurface> getTargetType() {
        return AbstractSurface.class;
    }
}
