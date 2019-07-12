package org.xmlobjects.gml.model.geometry.primitives;

import java.util.List;

public class PolygonPatchArrayProperty extends SurfacePatchArrayProperty<PolygonPatch> {

    public PolygonPatchArrayProperty() {
    }

    public PolygonPatchArrayProperty(List<PolygonPatch> objects) {
        super(objects);
    }

    @Override
    public Class<PolygonPatch> getTargetType() {
        return PolygonPatch.class;
    }
}
