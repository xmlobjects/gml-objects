package org.xmlobjects.gml.model.geometry.complexes;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSolid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CompositeSolid extends AbstractSolid implements AggregationAttributes {
    private List<SolidProperty> solidMembers;
    private AggregationType aggregationType;

    public CompositeSolid() {
    }

    public CompositeSolid(List<SolidProperty> curveMember) {
        setSolidMembers(curveMember);
    }

    public List<SolidProperty> getSolidMembers() {
        if (solidMembers == null)
            solidMembers = new ChildList<>(this);

        return solidMembers;
    }

    public void setSolidMembers(List<SolidProperty> solidMembers) {
        this.solidMembers = asChild(solidMembers);
    }

    @Override
    public AggregationType getAggregationType() {
        return aggregationType;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        this.aggregationType = aggregationType;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
