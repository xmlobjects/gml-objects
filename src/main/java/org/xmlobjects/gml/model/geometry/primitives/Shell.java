package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Shell extends AbstractSurface implements AggregationAttributes {
    private List<SurfaceProperty> surfaceMembers;

    public Shell() {
    }

    public Shell(List<SurfaceProperty> surfaceMembers) {
        setSurfaceMembers(surfaceMembers);
    }

    public List<SurfaceProperty> getSurfaceMembers() {
        if (surfaceMembers == null)
            surfaceMembers = new ChildList<>(this);

        return surfaceMembers;
    }

    public void setSurfaceMembers(List<SurfaceProperty> surfaceMembers) {
        this.surfaceMembers = asChild(surfaceMembers);
    }

    @Override
    public AggregationType getAggregationType() {
        return AggregationType.SET;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        //
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
