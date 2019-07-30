package org.xmlobjects.gml.model.geometry.complexes;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;

import java.util.List;

public class GeometricComplex extends AbstractGeometry implements AggregationAttributes {
    private List<GeometricPrimitiveProperty> elements;
    private AggregationType aggregationType;

    public GeometricComplex() {
    }

    public GeometricComplex(List<GeometricPrimitiveProperty> elements) {
        setElements(elements);
    }

    public List<GeometricPrimitiveProperty> getElements() {
        if (elements == null)
            elements = new ChildList<>(this);

        return elements;
    }

    public void setElements(List<GeometricPrimitiveProperty> elements) {
        this.elements = asChild(elements);
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
