/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class PointProperty extends GeometryProperty<Point> {

    public PointProperty() {
    }

    public PointProperty(Point point) {
        super(point);
    }

    public PointProperty(String href) {
        super(href);
    }

    @Override
    public Class<Point> getTargetType() {
        return Point.class;
    }
}
