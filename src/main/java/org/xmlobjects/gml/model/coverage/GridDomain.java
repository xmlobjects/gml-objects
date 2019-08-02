package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.geometry.grids.Grid;

public class GridDomain extends AbstractDomainSet<Grid> {

    public GridDomain() {
    }

    public GridDomain(Grid object) {
        super(object);
    }

    public GridDomain(String href) {
        super(href);
    }

    @Override
    public Class<Grid> getTargetType() {
        return Grid.class;
    }
}
