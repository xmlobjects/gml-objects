/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.base;

import org.xmlobjects.model.Child;

public abstract class AbstractInlineProperty<T extends Child> extends AbstractAssociation<T> {
    private T object;

    public AbstractInlineProperty() {
    }

    public AbstractInlineProperty(T object) {
        setObject(object);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = asChild(object);
    }

    public void setObjectIfValid(Child object) {
        if (object == null || getTargetType().isInstance(object)) {
            setObject(getTargetType().cast(object));
        }
    }
}
