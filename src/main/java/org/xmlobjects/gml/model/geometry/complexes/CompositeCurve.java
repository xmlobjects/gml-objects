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
import org.xmlobjects.gml.model.geometry.primitives.AbstractCurve;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositeCurve extends AbstractCurve implements AggregationAttributes {
    private List<CurveProperty> curveMembers;
    private AggregationType aggregationType;

    public CompositeCurve() {
    }

    public CompositeCurve(List<CurveProperty> curveMember) {
        setCurveMembers(curveMember);
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
        if (curveMembers != null && !curveMembers.isEmpty()) {
            List<Double> coordinates = new ArrayList<>();
            for (CurveProperty property : curveMembers) {
                if (property != null && property.getObject() != null) {
                    List<Double> candidates = property.getObject().toCoordinateList3D();
                    if (!candidates.isEmpty()) {
                        int size = coordinates.size();
                        if (size == 0)
                            coordinates.addAll(candidates);
                        else {
                            if (candidates.get(0).doubleValue() == coordinates.get(size - 3).doubleValue()
                                    && candidates.get(1).doubleValue() == coordinates.get(size - 2).doubleValue()
                                    && candidates.get(2).doubleValue() == coordinates.get(size - 1).doubleValue())
                                coordinates.addAll(candidates.subList(3, candidates.size()));
                            else
                                coordinates.addAll(candidates);
                        }
                    }
                }
            }

            return coordinates;
        } else
            return Collections.emptyList();
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
