package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.model.ChildList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ring extends AbstractRing implements AggregationAttributes {
    private List<CurveProperty> curveMembers;
    private AggregationType aggregationType;

    public Ring() {
    }

    public Ring(List<CurveProperty> curveMembers) {
        setCurveMembers(curveMembers);
    }

    public List<CurveProperty> getCurveMembers() {
        if (curveMembers == null)
            curveMembers = new ChildList<>(this);

        return curveMembers;
    }

    public void setCurveMembers(List<CurveProperty> curveMembers) {
        this.curveMembers = asChild(curveMembers);
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
    public List<Double> toCoordinateList3D() {
        if (curveMembers != null && !curveMembers.isEmpty())
            return curveMembers.stream()
                    .map(CurveProperty::getObject)
                    .filter(Objects::nonNull)
                    .map(AbstractCurve::toCoordinateList3D)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        else
            return Collections.emptyList();
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
