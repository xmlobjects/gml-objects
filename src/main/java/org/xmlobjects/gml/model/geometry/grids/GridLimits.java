package org.xmlobjects.gml.model.geometry.grids;

import org.xmlobjects.gml.model.GMLObject;

public class GridLimits extends GMLObject {
    private GridEnvelope gridEnvelope;

    public GridLimits() {
    }

    public GridLimits(GridEnvelope gridEnvelope) {
        this.gridEnvelope = gridEnvelope;
    }

    public GridEnvelope getGridEnvelope() {
        return gridEnvelope;
    }

    public void setGridEnvelope(GridEnvelope gridEnvelope) {
        this.gridEnvelope = asChild(gridEnvelope);
    }
}
