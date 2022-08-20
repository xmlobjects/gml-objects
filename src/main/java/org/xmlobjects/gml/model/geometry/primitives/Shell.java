/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.AggregationAttributes;
import org.xmlobjects.gml.model.base.AggregationType;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Shell extends AbstractSurface implements AggregationAttributes {
    private List<SurfaceProperty> surfaceMembers;

    public Shell() {
    }

    public Shell(List<SurfaceProperty> surfaceMembers) {
        setSurfaceMembers(surfaceMembers);
    }

    public Shell(CompositeSurface compositeSurface) {
        this(compositeSurface.isSetSurfaceMembers() ? compositeSurface.getSurfaceMembers() : null);
        setId(compositeSurface.getId());
        setDescription(compositeSurface.getDescription());
        setDescriptionReference(compositeSurface.getDescriptionReference());
        setIdentifier(compositeSurface.getIdentifier());
        setSrsName(compositeSurface.getSrsName());
        setSrsDimension(compositeSurface.getSrsDimension());

        if (compositeSurface.isSetMetaDataProperties()) {
            setMetaDataProperties(compositeSurface.getMetaDataProperties());
        }

        if (compositeSurface.isSetNames()) {
            setNames(compositeSurface.getNames());
        }

        if (compositeSurface.isSetAxisLabels()) {
            setAxisLabels(compositeSurface.getAxisLabels());
        }

        if (compositeSurface.isSetUomLabels()) {
            setUomLabels(compositeSurface.getUomLabels());
        }
    }

    public List<SurfaceProperty> getSurfaceMembers() {
        if (surfaceMembers == null)
            surfaceMembers = new ChildList<>(this);

        return surfaceMembers;
    }

    public boolean isSetSurfaceMembers() {
        return surfaceMembers != null && !surfaceMembers.isEmpty();
    }

    public void setSurfaceMembers(List<SurfaceProperty> surfaceMembers) {
        this.surfaceMembers = asChild(surfaceMembers);
    }

    @Override
    public AggregationType getAggregationType() {
        return AggregationType.SET;
    }

    @Override
    public void setAggregationType(AggregationType aggregationType) {
        //
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (surfaceMembers != null) {
            for (SurfaceProperty property : surfaceMembers) {
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
