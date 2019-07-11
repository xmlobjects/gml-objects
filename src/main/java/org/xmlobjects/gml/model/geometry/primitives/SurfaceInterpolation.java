package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.common.Enumeration;

public enum SurfaceInterpolation implements Enumeration<SurfaceInterpolation> {
    NONE("none"),
    PLANAR("planar"),
    SPHERICAL("spherical"),
    ELLIPTICAL("elliptical"),
    CONIC("conic"),
    TIN("tin"),
    PARAMETRIC_CURVE("parametricCurve"),
    POLYNOMIAL_SPLINE("polynomialSpline"),
    RATIONAL_SPLINE("rationalSpline"),
    TRIANGULATED_SPLINE("triangulatedSpline");

    private final String value;

    SurfaceInterpolation(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @Override
    public SurfaceInterpolation fromValue(String value) {
        for (SurfaceInterpolation v : SurfaceInterpolation.values()) {
            if (v.value.equals(value))
                return v;
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
