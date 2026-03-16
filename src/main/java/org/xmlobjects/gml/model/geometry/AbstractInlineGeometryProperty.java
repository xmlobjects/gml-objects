/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public abstract class AbstractInlineGeometryProperty<T extends AbstractGeometry> extends AbstractInlineProperty<T> {

    public AbstractInlineGeometryProperty() {
    }

    public AbstractInlineGeometryProperty(T object) {
        super(object);
    }
}
