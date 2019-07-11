package org.xmlobjects.gml.model.geometry.primitives;

public class Triangle extends AbstractSurfacePatch {
    private AbstractRingProperty exterior;

    public Triangle() {
    }

    public Triangle(AbstractRingProperty exterior) {
        setExterior(exterior);
    }

    public Triangle(AbstractRing exterior) {
        this(new AbstractRingProperty(exterior));
    }

    public AbstractRingProperty getExterior() {
        return exterior;
    }

    public void setExterior(AbstractRingProperty exterior) {
        this.exterior = asChild(exterior);
    }

    public SurfaceInterpolation getInterpolation() {
        return SurfaceInterpolation.PLANAR;
    }
}
