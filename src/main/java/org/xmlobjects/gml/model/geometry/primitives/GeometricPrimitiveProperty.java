/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class GeometricPrimitiveProperty extends GeometryProperty<AbstractGeometricPrimitive> {

    public GeometricPrimitiveProperty() {
    }

    public GeometricPrimitiveProperty(AbstractGeometricPrimitive primitive) {
        super(primitive);
    }

    public GeometricPrimitiveProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractGeometricPrimitive> getTargetType() {
        return AbstractGeometricPrimitive.class;
    }
}
