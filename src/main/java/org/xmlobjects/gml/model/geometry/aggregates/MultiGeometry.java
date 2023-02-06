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

import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiGeometry extends AbstractGeometricAggregate {
    private List<GeometryProperty<?>> geometryMember;
    private GeometryArrayProperty<?> geometryMembers;

    public MultiGeometry() {
    }

    public MultiGeometry(List<GeometryProperty<?>> geometryMember) {
        setGeometryMember(geometryMember);
    }

    public List<GeometryProperty<?>> getGeometryMember() {
        if (geometryMember == null)
            geometryMember = new ChildList<>(this);

        return geometryMember;
    }

    public boolean isSetGeometryMember() {
        return geometryMember != null && !geometryMember.isEmpty();
    }

    public void setGeometryMember(List<GeometryProperty<?>> geometryMember) {
        this.geometryMember = asChild(geometryMember);
    }

    public GeometryArrayProperty<?> getGeometryMembers() {
        return geometryMembers;
    }

    public void setGeometryMembers(GeometryArrayProperty<?> geometryMembers) {
        this.geometryMembers = asChild(geometryMembers);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (geometryMember != null) {
            for (GeometryProperty<?> property : geometryMember) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope());
            }
        }

        if (geometryMembers != null && geometryMembers.isSetObjects()) {
            for (AbstractGeometry geometry : geometryMembers.getObjects())
                envelope.include(geometry.computeEnvelope());
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
