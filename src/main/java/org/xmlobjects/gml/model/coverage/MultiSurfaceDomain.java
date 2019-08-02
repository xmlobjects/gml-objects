package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;

public class MultiSurfaceDomain extends AbstractDomainSet<MultiSurface> {

    public MultiSurfaceDomain() {
    }

    public MultiSurfaceDomain(MultiSurface object) {
        super(object);
    }

    public MultiSurfaceDomain(String href) {
        super(href);
    }

    @Override
    public Class<MultiSurface> getTargetType() {
        return MultiSurface.class;
    }
}
