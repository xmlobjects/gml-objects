/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.gml.visitor.VisitableObject;

public abstract class AbstractCoverage<T extends AbstractDomainSet<?>> extends AbstractFeature implements VisitableObject {
    private T domainSet;
    private RangeSet rangeSet;

    public AbstractCoverage() {
    }

    public AbstractCoverage(T domainSet, RangeSet rangeSet) {
        setDomainSet(domainSet);
        setRangeSet(rangeSet);
    }

    public T getDomainSet() {
        return domainSet;
    }

    public void setDomainSet(T domainSet) {
        this.domainSet = asChild(domainSet);
    }

    public RangeSet getRangeSet() {
        return rangeSet;
    }

    public void setRangeSet(RangeSet rangeSet) {
        this.rangeSet = asChild(rangeSet);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        if (domainSet != null && domainSet.getObject() instanceof AbstractGeometry geometry) {
            envelope.include(geometry.computeEnvelope());
        }
    }
}
