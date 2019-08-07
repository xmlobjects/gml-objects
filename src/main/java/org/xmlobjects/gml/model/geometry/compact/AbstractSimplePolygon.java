package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;

public abstract class AbstractSimplePolygon extends AbstractSurface {
    private GeometricPositionList controlPoints;

    public AbstractSimplePolygon() {
    }

    public AbstractSimplePolygon(GeometricPositionList controlPoints) {
        setControlPoints(controlPoints);
    }

    public AbstractSimplePolygon(DirectPositionList posList) {
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
}
