/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiPoint extends AbstractMultiPoint {
    private List<PointProperty> pointMember;
    private PointArrayProperty pointMembers;

    public MultiPoint() {
    }

    public MultiPoint(List<PointProperty> pointMember) {
        setPointMember(pointMember);
    }

    public List<PointProperty> getPointMember() {
        if (pointMember == null)
            pointMember = new ChildList<>(this);

        return pointMember;
    }

    public boolean isSetPointMember() {
        return pointMember != null && !pointMember.isEmpty();
    }

    public void setPointMember(List<PointProperty> pointMember) {
        this.pointMember = asChild(pointMember);
    }

    public PointArrayProperty getPointMembers() {
        return pointMembers;
    }

    public void setPointMembers(PointArrayProperty pointMembers) {
        this.pointMembers = asChild(pointMembers);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (pointMember != null) {
            for (PointProperty property : pointMember) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope());
            }
        }

        if (pointMembers != null && pointMembers.isSetObjects()) {
            for (Point point : pointMembers.getObjects())
                envelope.include(point.computeEnvelope());
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
