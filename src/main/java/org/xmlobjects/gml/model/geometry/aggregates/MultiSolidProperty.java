/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class MultiSolidProperty extends GeometryProperty<MultiSolid> {

    public MultiSolidProperty() {
    }

    public MultiSolidProperty(MultiSolid multiSolid) {
        super(multiSolid);
    }

    public MultiSolidProperty(String href) {
        super(href);
    }

    @Override
    public Class<MultiSolid> getTargetType() {
        return MultiSolid.class;
    }
}
