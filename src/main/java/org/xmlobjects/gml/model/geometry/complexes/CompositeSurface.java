package org.xmlobjects.gml.model.geometry.complexes;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.util.List;

public class CompositeSurface extends AbstractSurface implements AggregationAttributes {
    private List<SurfaceProperty> surfaceMembers;
    private AggregationType aggregationType;

    public CompositeSurface() {
    }

    public CompositeSurface(List<SurfaceProperty> curveMember) {
        setSurfaceMembers(curveMember);
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
        return aggregationType;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        this.aggregationType = aggregationType;
    }
}
