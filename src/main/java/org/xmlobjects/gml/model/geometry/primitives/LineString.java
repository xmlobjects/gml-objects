package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;

import java.util.Collections;
import java.util.List;

public class LineString extends AbstractCurve implements CoordinateListProvider {
    private GeometricPositionList controlPoints;

    public LineString() {
    }

    public LineString(GeometricPositionList controlPoints) {
        this.controlPoints = controlPoints;
    }

    public GeometricPositionList getControlPoints() {
        return controlPoints;
    }

    public void setControlPoints(GeometricPositionList controlPoints) {
        this.controlPoints = asChild(controlPoints);
    }

    @Override
    public List<Double> toCoordinateList3D() {
        return controlPoints != null ? controlPoints.toCoordinateList3D() : Collections.emptyList();
    }
}
