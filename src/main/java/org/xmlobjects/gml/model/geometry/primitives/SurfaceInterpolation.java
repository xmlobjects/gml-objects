/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.model.geometry.primitives;

public enum SurfaceInterpolation {
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

    public String toValue() {
        return value;
    }

    public static SurfaceInterpolation fromValue(String value) {
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
