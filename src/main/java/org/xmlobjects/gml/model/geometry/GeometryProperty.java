/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class GeometryProperty<T extends AbstractGeometry> extends AbstractProperty<T> {

    public GeometryProperty() {
    }

    public GeometryProperty(T object) {
        super(object);
    }

    public GeometryProperty(String href) {
        super(href);
    }

    @Override
    public T getObject() {
        return super.getObject();
    }

    @Override
    public void setInlineObject(T object) {
        super.setInlineObject(object);
    }

    @Override
    public void setReferencedObject(T object) {
        super.setReferencedObject(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractGeometry.class;
    }
}
