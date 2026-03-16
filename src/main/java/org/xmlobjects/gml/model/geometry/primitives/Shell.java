/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
