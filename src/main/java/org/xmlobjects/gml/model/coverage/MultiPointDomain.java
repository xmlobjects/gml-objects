package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;

public class MultiPointDomain extends AbstractDomainSet<MultiPoint> {

    public MultiPointDomain() {
    }

    public MultiPointDomain(MultiPoint object) {
        super(object);
    }

    public MultiPointDomain(String href) {
        super(href);
    }

    @Override
    public Class<MultiPoint> getTargetType() {
        return MultiPoint.class;
    }
}
