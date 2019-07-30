package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.visitor.GeometryVisitor;

import java.util.Collections;
import java.util.List;

public class LinearRing extends AbstractRing {
    private GeometricPositionList controlPoints;

    public LinearRing() {
    }

    public LinearRing(GeometricPositionList controlPoints) {
        setControlPoints(controlPoints);
    }

    public LinearRing(DirectPositionList posList) {
        this(new GeometricPositionList(posList));
    }

    public GeometricPositionList getControlPoints() {
        if (controlPoints == null)
            controlPoints = asChild(new GeometricPositionList());

        return controlPoints;
    }

    public void setControlPoints(GeometricPositionList controlPoints) {
        this.controlPoints = asChild(controlPoints);
    }

    @Override
    public List<Double> toCoordinateList3D() {
        return controlPoints != null ? controlPoints.toCoordinateList3D() : Collections.emptyList();
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
