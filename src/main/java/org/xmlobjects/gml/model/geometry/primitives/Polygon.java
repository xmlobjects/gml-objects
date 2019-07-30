package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.visitor.GeometryVisitor;

import java.util.List;

public class Polygon extends AbstractSurface {
    private AbstractRingProperty exterior;
    private List<AbstractRingProperty> interior;

    public Polygon() {
    }

    public Polygon(AbstractRingProperty exterior) {
        setExterior(exterior);
    }

    public Polygon(AbstractRing exterior) {
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

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
