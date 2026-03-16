/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;

import java.util.List;

public class PointArrayProperty extends GeometryArrayProperty<Point> {

    public PointArrayProperty() {
    }

    public PointArrayProperty(List<Point> points) {
        super(points);
    }

    @Override
    public Class<Point> getTargetType() {
        return Point.class;
    }
}
