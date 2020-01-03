package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

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

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (baseSurface != null && baseSurface.getObject() != null)
            envelope.include(baseSurface.getObject().computeEnvelope());

        return envelope;
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
