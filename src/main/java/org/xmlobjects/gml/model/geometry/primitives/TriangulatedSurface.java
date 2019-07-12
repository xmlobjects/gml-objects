package org.xmlobjects.gml.model.geometry.primitives;

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
    public void setPatches(SurfacePatchArrayProperty patches) {
        if (!(patches instanceof TriangleArrayProperty))
            throw new IllegalArgumentException("Only a triangle array property is allowed.");

        setPatches((TriangleArrayProperty) patches);
    }

    public void setPatches(TriangleArrayProperty patches) {
        super.setPatches(patches);
    }
}
