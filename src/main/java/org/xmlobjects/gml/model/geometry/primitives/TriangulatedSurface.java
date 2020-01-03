package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class TriangulatedSurface extends Surface {

    public TriangulatedSurface() {
    }

    public TriangulatedSurface(TriangleArrayProperty patches) {
        super(patches);
    }

    @Override
    public TriangleArrayProperty getPatches() {
        return (TriangleArrayProperty) super.getPatches();
    }

    @Override
    public void setPatches(SurfacePatchArrayProperty<?> patches) {
        if (!(patches instanceof TriangleArrayProperty))
            throw new IllegalArgumentException("Only a triangle array property is allowed.");

        setPatches((TriangleArrayProperty) patches);
    }

    public void setPatches(TriangleArrayProperty patches) {
        super.setPatches(patches);
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
