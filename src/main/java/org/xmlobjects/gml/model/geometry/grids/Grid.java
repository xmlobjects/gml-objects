package org.xmlobjects.gml.model.geometry.grids;

import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.ArrayList;
import java.util.List;

public class Grid extends AbstractGeometry {
    private GridLimits limits;
    private List<String> gridAxisLabels;
    private Integer dimension;

    public Grid() {
    }

    public Grid(Integer dimension) {
        setDimension(dimension);
    }

    public GridLimits getLimits() {
        return limits;
    }

    public void setLimits(GridLimits limits) {
        this.limits = asChild(limits);
    }

    public List<String> getGridAxisLabels() {
        if (gridAxisLabels == null)
            gridAxisLabels = new ArrayList<>();

        return gridAxisLabels;
    }

    public void setGridAxisLabels(List<String> gridAxisLabels) {
        this.gridAxisLabels = gridAxisLabels;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        if (dimension != null && dimension > 0)
            this.dimension = dimension;
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
