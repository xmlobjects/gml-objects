/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.primitives.AbstractCurve;
import org.xmlobjects.gml.model.geometry.primitives.CurveArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiCurve extends AbstractGeometricAggregate {
    private List<CurveProperty> curveMember;
    private CurveArrayProperty curveMembers;

    public MultiCurve() {
    }

    public MultiCurve(List<CurveProperty> curveMember) {
        setCurveMember(curveMember);
    }

    public List<CurveProperty> getCurveMember() {
        if (curveMember == null)
            curveMember = new ChildList<>(this);

        return curveMember;
    }

    public boolean isSetCurveMember() {
        return curveMember != null && !curveMember.isEmpty();
    }

    public void setCurveMember(List<CurveProperty> curveMember) {
        this.curveMember = asChild(curveMember);
    }

    public CurveArrayProperty getCurveMembers() {
        return curveMembers;
    }

    public void setCurveMembers(CurveArrayProperty curveMembers) {
        this.curveMembers = asChild(curveMembers);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (curveMember != null) {
            for (CurveProperty property : curveMember) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope());
            }
        }

        if (curveMembers != null && curveMembers.isSetObjects()) {
            for (AbstractCurve curve : curveMembers.getObjects())
                envelope.include(curve.computeEnvelope());
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
