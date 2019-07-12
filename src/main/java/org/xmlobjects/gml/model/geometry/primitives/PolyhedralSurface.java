package org.xmlobjects.gml.model.geometry.primitives;

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
    public void setPatches(SurfacePatchArrayProperty patches) {
        if (!(patches instanceof PolygonPatchArrayProperty))
            throw new IllegalArgumentException("Only a polygon patch array property is allowed.");

        setPatches((PolygonPatchArrayProperty) patches);
    }

    public void setPatches(PolygonPatchArrayProperty patches) {
        super.setPatches(patches);
    }
}
