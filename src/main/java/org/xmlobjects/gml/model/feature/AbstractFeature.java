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
