package org.xmlobjects.gml.model.geometry.primitives;

import java.util.List;

public class TriangleArrayProperty extends SurfacePatchArrayProperty {

    public TriangleArrayProperty() {
    }

    @SuppressWarnings("unchecked")
    public TriangleArrayProperty(List<Triangle> objects) {
        super((List) objects);
    }

    @Override
    public List<AbstractSurfacePatch> getObjects() {
        super.getObjects().removeIf(p -> !(p instanceof Triangle));
        return super.getObjects();
    }

    @SuppressWarnings("unchecked")
    public List<Triangle> getTriangles() {
        return (List) getObjects();
    }
}
