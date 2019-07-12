package org.xmlobjects.gml.model.geometry.primitives;

import java.util.List;

public class PolygonPatchArrayProperty extends SurfacePatchArrayProperty {

    public PolygonPatchArrayProperty() {
    }

    @SuppressWarnings("unchecked")
    public PolygonPatchArrayProperty(List<PolygonPatch> objects) {
        super((List) objects);
    }

    @Override
    public List<AbstractSurfacePatch> getObjects() {
        super.getObjects().removeIf(p -> !(p instanceof PolygonPatch));
        return super.getObjects();
    }

    @SuppressWarnings("unchecked")
    public List<PolygonPatch> getPolygons() {
        return (List) getObjects();
    }
}
