package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CompositeValue extends AbstractGML implements AggregationAttributes {
    private List<ValueProperty> valueComponent;
    private ValueArrayProperty valueComponents;
    private AggregationType aggregationType;

    public CompositeValue() {
    }

    public CompositeValue(List<ValueProperty> valueComponent) {
        setValueComponent(valueComponent);
    }

    public List<ValueProperty> getValueComponent() {
        if (valueComponent == null)
            valueComponent = new ChildList<>(this);

        return valueComponent;
    }

    public void setValueComponent(List<ValueProperty> valueComponent) {
        this.valueComponent = asChild(valueComponent);
    }

    public ValueArrayProperty getValueComponents() {
        return valueComponents;
    }

    public void setValueComponents(ValueArrayProperty valueComponents) {
        this.valueComponents = asChild(valueComponents);
    }

    @Override
    public AggregationType getAggregationType() {
        return aggregationType;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        this.aggregationType = aggregationType;
    }

    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
