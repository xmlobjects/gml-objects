package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class Surface extends AbstractSurface {
    private SurfacePatchArrayProperty<?> patches;

    public Surface() {
    }

    public Surface(SurfacePatchArrayProperty<?> patches) {
        setPatches(patches);
    }

    public SurfacePatchArrayProperty<?> getPatches() {
        return patches;
    }

    public void setPatches(SurfacePatchArrayProperty<?> patches) {
        this.patches = asChild(patches);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
