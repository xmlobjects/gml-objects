package org.xmlobjects.gml.model.geometry.primitives;

public enum CurveInterpolation {
    LINEAR("linear"),
    GEODESIC("geodesic"),
    CIRCULAR_ARC_3_POINTS("circularArc3Points"),
    CIRCULAR_ARC_2_POINT_WITH_BULGE("circularArc2PointWithBulge"),
    CIRCULAR_ARC_CENTER_POINT_WITH_RADIUS("circularArcCenterPointWithRadius"),
    ELLIPTICAL("elliptical"),
    CLOTHOID("clothoid"),
    CONIC("conic"),
    POLYNOMIAL_SPLINE("polynomialSpline"),
    CUBIC_SPLINE("cubicSpline"),
    RATIONAL_SPLINE("rationalSpline");

    private final String value;

    CurveInterpolation(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static CurveInterpolation fromValue(String value) {
        for (CurveInterpolation v : CurveInterpolation.values()) {
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
