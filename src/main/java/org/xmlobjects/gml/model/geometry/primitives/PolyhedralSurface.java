package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class PolyhedralSurface extends Surface {

    public PolyhedralSurface() {
    }

    public PolyhedralSurface(PolygonPatchArrayProperty patches) {
        super(patches);
    }

    @Override
    public PolygonPatchArrayProperty getPatches() {
        return (PolygonPatchArrayProperty) super.getPatches();
    }

    @Override
    public void setPatches(SurfacePatchArrayProperty<?> patches) {
        if (!(patches instanceof PolygonPatchArrayProperty))
            throw new IllegalArgumentException("Only a polygon patch array property is allowed.");

        setPatches((PolygonPatchArrayProperty) patches);
    }

    public void setPatches(PolygonPatchArrayProperty patches) {
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
