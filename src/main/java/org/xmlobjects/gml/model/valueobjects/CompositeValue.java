/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2021 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class CompositeValue extends AbstractGML implements AbstractValue, AggregationAttributes {
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
