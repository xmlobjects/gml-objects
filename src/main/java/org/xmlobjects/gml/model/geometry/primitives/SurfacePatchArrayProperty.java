package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.ArrayProperty;

import java.util.List;

public class SurfacePatchArrayProperty extends ArrayProperty<AbstractSurfacePatch> {

    public SurfacePatchArrayProperty() {
    }

    public SurfacePatchArrayProperty(List<AbstractSurfacePatch> objects) {
        super(objects);
    }

    @Override
    public Class<AbstractSurfacePatch> getTargetType() {
        return AbstractSurfacePatch.class;
    }
}
