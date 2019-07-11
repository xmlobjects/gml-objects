package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import java.util.Collections;
import java.util.List;

public class GeometricPosition extends GMLObject implements CoordinateListProvider {
    private DirectPosition pos;
    private PointProperty pointProperty;

    public GeometricPosition() {
    }

    public GeometricPosition(DirectPosition pos) {
        setPos(pos);
    }

    public GeometricPosition(PointProperty pointProperty) {
        setPointProperty(pointProperty);
    }

    public DirectPosition getPos() {
        return pos;
    }

    public boolean isSetPos() {
        return pos != null;
    }

    public void setPos(DirectPosition pos) {
        this.pos = asChild(pos);
        pointProperty = null;
    }

    public PointProperty getPointProperty() {
        return pointProperty;
    }

    public boolean isSetPointProperty() {
        return pointProperty != null;
    }

    public void setPointProperty(PointProperty pointProperty) {
        this.pointProperty = asChild( pointProperty);
        pos = null;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        if (pos != null)
            return pos.toCoordinateList3D();
        else if (pointProperty != null && pointProperty.getObject() != null)
            return pointProperty.getObject().toCoordinateList3D();
        else
            return Collections.emptyList();
    }
}
