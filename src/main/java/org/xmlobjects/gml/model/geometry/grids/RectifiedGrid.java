package org.xmlobjects.gml.model.geometry.grids;

import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.Vector;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;

import java.util.List;

public class RectifiedGrid extends Grid {
    private PointProperty origin;
    private List<Vector> offsetVectors;

    public PointProperty getOrigin() {
        return origin;
    }

    public void setOrigin(PointProperty origin) {
        this.origin = asChild(origin);
    }

    public List<Vector> getOffsetVectors() {
        if (offsetVectors == null)
            offsetVectors = new ChildList<>(this);

        return offsetVectors;
    }

    public void setOffsetVectors(List<Vector> offsetVectors) {
        this.offsetVectors = asChild(offsetVectors);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
