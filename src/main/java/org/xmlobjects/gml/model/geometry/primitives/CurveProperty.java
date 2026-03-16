/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class CurveProperty extends GeometryProperty<AbstractCurve> {

    public CurveProperty() {
    }

    public CurveProperty(AbstractCurve curve) {
        super(curve);
    }

    public CurveProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractCurve> getTargetType() {
        return AbstractCurve.class;
    }
}
