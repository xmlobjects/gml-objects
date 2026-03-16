/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class MultiGeometryProperty extends GeometryProperty<MultiGeometry> {

    public MultiGeometryProperty() {
    }

    public MultiGeometryProperty(MultiGeometry multiGeometry) {
        super(multiGeometry);
    }

    public MultiGeometryProperty(String href) {
        super(href);
    }

    @Override
    public Class<MultiGeometry> getTargetType() {
        return MultiGeometry.class;
    }
}
