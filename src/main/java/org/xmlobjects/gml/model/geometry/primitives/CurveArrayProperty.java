package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;

import java.util.List;

public class CurveArrayProperty extends GeometryArrayProperty<AbstractCurve> {

    public CurveArrayProperty() {
    }

    public CurveArrayProperty(List<AbstractCurve> curves) {
        super(curves);
    }

    @Override
    public Class<AbstractCurve> getTargetType() {
        return AbstractCurve.class;
    }
}
