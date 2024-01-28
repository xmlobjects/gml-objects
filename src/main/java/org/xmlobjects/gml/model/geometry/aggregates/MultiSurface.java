/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiSurface extends AbstractGeometricAggregate {
    private List<SurfaceProperty> surfaceMember;
    private SurfaceArrayProperty surfaceMembers;

    public MultiSurface() {
    }

    public MultiSurface(List<SurfaceProperty> surfaceMember) {
        setSurfaceMember(surfaceMember);
    }

    public List<SurfaceProperty> getSurfaceMember() {
        if (surfaceMember == null)
            surfaceMember = new ChildList<>(this);

        return surfaceMember;
    }

    public boolean isSetSurfaceMember() {
        return surfaceMember != null && !surfaceMember.isEmpty();
    }

    public void setSurfaceMember(List<SurfaceProperty> surfaceMember) {
        this.surfaceMember = asChild(surfaceMember);
    }

    public SurfaceArrayProperty getSurfaceMembers() {
        return surfaceMembers;
    }

    public void setSurfaceMembers(SurfaceArrayProperty surfaceMembers) {
        this.surfaceMembers = asChild(surfaceMembers);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (surfaceMember != null) {
            for (SurfaceProperty property : surfaceMember) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope());
            }
        }

        if (surfaceMembers != null && surfaceMembers.isSetObjects()) {
            for (AbstractSurface surface : surfaceMembers.getObjects())
                envelope.include(surface.computeEnvelope());
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
