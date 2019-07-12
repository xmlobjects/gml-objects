package org.xmlobjects.gml.model.geometry.primitives;

import java.util.List;

public class TriangleArrayProperty extends SurfacePatchArrayProperty<Triangle> {

    public TriangleArrayProperty() {
    }

    public TriangleArrayProperty(List<Triangle> objects) {
        super(objects);
    }

    @Override
    public Class<Triangle> getTargetType() {
        return Triangle.class;
    }
}
