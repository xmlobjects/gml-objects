package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class SurfaceProperty extends GeometryProperty<AbstractSurface> {

    public SurfaceProperty() {
    }

    public SurfaceProperty(AbstractSurface surface) {
        super(surface);
    }

    public SurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractSurface> getTargetType() {
        return AbstractSurface.class;
    }
}
