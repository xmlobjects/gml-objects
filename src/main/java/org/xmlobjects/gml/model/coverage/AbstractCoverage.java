/*
 * gml-objects - A Java XML binding for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public abstract class AbstractCoverage<T extends AbstractDomainSet<?>> extends AbstractFeature {
    private T domainSet;
    private RangeSet rangeSet;

    public AbstractCoverage() {
    }

    public AbstractCoverage(T domainSet, RangeSet rangeSet) {
        setDomainSet(domainSet);
        setRangeSet(rangeSet);
    }

    public abstract void accept(ObjectVisitor visitor);

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
        if (domainSet != null && domainSet.getObject() instanceof AbstractGeometry) {
            AbstractGeometry geometry = (AbstractGeometry) domainSet.getObject();
            envelope.include(geometry.computeEnvelope());
        }
    }
}
