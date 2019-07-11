package org.xmlobjects.gml.model.geometry.primitives;

public class Surface extends AbstractSurface {
    private SurfacePatchArrayProperty patches;

    public Surface() {
    }

    public Surface(SurfacePatchArrayProperty patches) {
        setPatches(patches);
    }

    public SurfacePatchArrayProperty getPatches() {
        return patches;
    }

    public void setPatches(SurfacePatchArrayProperty patches) {
        this.patches = asChild(patches);
    }
}
