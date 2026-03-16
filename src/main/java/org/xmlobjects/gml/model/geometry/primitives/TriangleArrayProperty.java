/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import java.util.List;

public class TriangleArrayProperty extends SurfacePatchArrayProperty<Triangle> {

    public TriangleArrayProperty() {
    }

    public TriangleArrayProperty(List<Triangle> objects) {
        super(objects);
    }

    @Override
    public Class<Triangle> getTargetType() {
        return Triangle.class;
    }
}
