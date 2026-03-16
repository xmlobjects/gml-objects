/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class SolidProperty extends GeometryProperty<AbstractSolid> {

    public SolidProperty() {
    }

    public SolidProperty(AbstractSolid solid) {
        super(solid);
    }

    public SolidProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractSolid> getTargetType() {
        return AbstractSolid.class;
    }
}
