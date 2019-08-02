package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.geometry.grids.RectifiedGrid;

public class RectifiedGridDomain extends AbstractDomainSet<RectifiedGrid> {

    public RectifiedGridDomain() {
    }

    public RectifiedGridDomain(RectifiedGrid object) {
        super(object);
    }

    public RectifiedGridDomain(String href) {
        super(href);
    }

    @Override
    public Class<RectifiedGrid> getTargetType() {
        return RectifiedGrid.class;
    }
}
