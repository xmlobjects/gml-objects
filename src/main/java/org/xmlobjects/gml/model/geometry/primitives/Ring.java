package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ring extends AbstractRing implements AggregationAttributes {
    private List<CurveProperty> curveMember;
    private AggregationType aggregationType;

    public Ring() {
    }

    public Ring(List<CurveProperty> curveMember) {
        setCurveMember(curveMember);
    }

    public List<CurveProperty> getCurveMember() {
        if (curveMember == null)
            curveMember = new ChildList<>(this);

        return curveMember;
    }

    public void setCurveMember(List<CurveProperty> curveMember) {
        this.curveMember = asChild(curveMember);
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
        if (curveMember != null && !curveMember.isEmpty())
            return curveMember.stream()
                    .map(CurveProperty::getObject)
                    .filter(Objects::nonNull)
                    .map(AbstractCurve::toCoordinateList3D)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        else
            return Collections.emptyList();
    }
}
