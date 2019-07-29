package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.basictypes.Sign;

public class OrientableSurface extends AbstractSurface {
    private SurfaceProperty baseSurface;
    private Sign orientation;

    public OrientableSurface() {
    }

    public OrientableSurface(SurfaceProperty baseSurface) {
        setBaseSurface(baseSurface);
    }

    public OrientableSurface(AbstractSurface baseSurface) {
        this(new SurfaceProperty(baseSurface));
    }

    public SurfaceProperty getBaseSurface() {
        return baseSurface;
    }

    public void setBaseSurface(SurfaceProperty baseSurface) {
        this.baseSurface = asChild(baseSurface);
    }

    public Sign getOrientation() {
        return orientation != null ? orientation : Sign.PLUS;
    }

    public void setOrientation(Sign orientation) {
        this.orientation = orientation;
    }
}
