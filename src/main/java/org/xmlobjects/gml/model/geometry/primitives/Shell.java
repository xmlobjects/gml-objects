package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class Shell extends AbstractSurface implements AggregationAttributes {
    private List<SurfaceProperty> surfaceMember;

    public Shell() {
    }

    public Shell(List<SurfaceProperty> surfaceMember) {
        setSurfaceMember(surfaceMember);
    }

    public List<SurfaceProperty> getSurfaceMember() {
        if (surfaceMember == null)
            surfaceMember = new ChildList<>(this);

        return surfaceMember;
    }

    public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
        this.surfaceMember = asChild(surfaceMember);
    }

    @Override
    public AggregationType getAggregationType() {
        return AggregationType.SET;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        //
    }
}
