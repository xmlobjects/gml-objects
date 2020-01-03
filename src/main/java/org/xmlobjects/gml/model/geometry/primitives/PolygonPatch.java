package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class PolygonPatch extends AbstractSurfacePatch {
    private AbstractRingProperty exterior;
    private List<AbstractRingProperty> interior;

    public PolygonPatch() {
    }

    public PolygonPatch(AbstractRingProperty exterior) {
        setExterior(exterior);
    }

    public PolygonPatch(AbstractRing exterior) {
        this(new AbstractRingProperty(exterior));
    }

    public AbstractRingProperty getExterior() {
        return exterior;
    }

    public void setExterior(AbstractRingProperty exterior) {
        this.exterior = asChild(exterior);
    }

    public List<AbstractRingProperty> getInterior() {
        if (interior == null)
            interior = new ChildList<>(this);

        return interior;
    }

    public void setInterior(List<AbstractRingProperty> interior) {
        this.interior = asChild(interior);
    }

    public SurfaceInterpolation getInterpolation() {
        return SurfaceInterpolation.PLANAR;
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (exterior != null && exterior.getObject() != null)
            envelope.include(exterior.getObject().computeEnvelope());

        return envelope;
    }
}
