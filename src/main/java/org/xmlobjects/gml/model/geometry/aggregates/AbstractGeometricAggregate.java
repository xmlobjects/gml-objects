package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public abstract class AbstractGeometricAggregate extends AbstractGeometry implements AggregationAttributes {
    private AggregationType aggregationType;

    @Override
    public AggregationType getAggregationType() {
        return aggregationType;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        this.aggregationType = aggregationType;
    }
}
