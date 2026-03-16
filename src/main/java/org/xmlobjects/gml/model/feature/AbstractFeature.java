/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.deprecated.LocationProperty;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractFeature extends AbstractGML {
    private BoundingShape boundedBy;
    private LocationProperty location;
    private List<GenericElement> genericProperties;

    protected abstract void updateEnvelope(Envelope envelope, EnvelopeOptions options);

    public BoundingShape getBoundedBy() {
        return boundedBy;
    }

    public void setBoundedBy(BoundingShape boundedBy) {
        this.boundedBy = asChild(boundedBy);
    }

    public LocationProperty getLocation() {
        return location;
    }

    public void setLocation(LocationProperty location) {
        this.location = asChild(location);
    }

    public List<GenericElement> getGenericProperties() {
        if (genericProperties == null)
            genericProperties = new ChildList<>(this);

        return genericProperties;
    }

    public boolean isSetGenericProperties() {
        return genericProperties != null && !genericProperties.isEmpty();
    }

    public void setGenericProperties(List<GenericElement> genericProperties) {
        this.genericProperties = asChild(genericProperties);
    }

    public final Envelope computeEnvelope(EnvelopeOptions options) {
        Envelope current = boundedBy != null && boundedBy.isSetEnvelope() ?
                boundedBy.getEnvelope() :
                null;

        if (options.isReuseExistingEnvelopes()
                && current != null
                && current.isValid()) {
            return current;
        }

        Envelope envelope = new Envelope();
        updateEnvelope(envelope, options);

        if (envelope.isValid()) {
            envelope.setSrsDimension(envelope.getDimension());

            if (current != null) {
                envelope.setSrsName(current.getSrsName());
                envelope.setAxisLabels(current.getAxisLabels());
                envelope.setUomLabels(current.getUomLabels());
            }

            if (options.isSetEnvelopeOnFeatures()) {
                setBoundedBy(new BoundingShape(envelope));
            }
        }

        return envelope;
    }

    public final Envelope computeEnvelope() {
        return computeEnvelope(EnvelopeOptions.defaults());
    }
}
