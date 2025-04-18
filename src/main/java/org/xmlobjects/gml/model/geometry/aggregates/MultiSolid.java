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
import org.xmlobjects.gml.model.geometry.primitives.AbstractSolid;
import org.xmlobjects.gml.model.geometry.primitives.SolidArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiSolid extends AbstractGeometricAggregate {
    private List<SolidProperty> solidMember;
    private SolidArrayProperty solidMembers;

    public MultiSolid() {
    }

    public MultiSolid(List<SolidProperty> solidMember) {
        setSolidMember(solidMember);
    }

    public List<SolidProperty> getSolidMember() {
        if (solidMember == null)
            solidMember = new ChildList<>(this);

        return solidMember;
    }

    public boolean isSetSolidMember() {
        return solidMember != null && !solidMember.isEmpty();
    }

    public void setSolidMember(List<SolidProperty> solidMember) {
        this.solidMember = asChild(solidMember);
    }

    public SolidArrayProperty getSolidMembers() {
        return solidMembers;
    }

    public void setSolidMembers(SolidArrayProperty solidMembers) {
        this.solidMembers = asChild(solidMembers);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (solidMember != null) {
            for (SolidProperty property : solidMember) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope());
            }
        }

        if (solidMembers != null && solidMembers.isSetObjects()) {
            for (AbstractSolid solid : solidMembers.getObjects())
                envelope.include(solid.computeEnvelope());
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
