package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class MultiSurfaceProperty extends GeometryProperty<MultiSurface> {

    public MultiSurfaceProperty() {
    }

    public MultiSurfaceProperty(MultiSurface multiSurface) {
        super(multiSurface);
    }

    public MultiSurfaceProperty(String href) {
        super(href);
    }

    @Override
    public Class<MultiSurface> getTargetType() {
        return MultiSurface.class;
    }
}
