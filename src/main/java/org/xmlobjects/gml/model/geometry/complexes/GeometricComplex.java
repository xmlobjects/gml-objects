/*
 * gml-objects - A Java XML binding for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.geometry.complexes;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

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
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (elements != null) {
            for (GeometricPrimitiveProperty property : elements) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope());
            }
        }

        return envelope;
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
