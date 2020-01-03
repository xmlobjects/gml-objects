package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.Collections;
import java.util.List;

public class LineString extends AbstractCurve {
    private GeometricPositionList controlPoints;

    public LineString() {
    }

    public LineString(GeometricPositionList controlPoints) {
        setControlPoints(controlPoints);
    }

    public LineString(DirectPositionList posList) {
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
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
