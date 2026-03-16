/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.base;

import org.xmlobjects.model.Child;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractArrayProperty<T extends Child> extends AbstractAssociation<T> {
    private List<T> objects;

    public AbstractArrayProperty() {
    }

    public AbstractArrayProperty(List<T> objects) {
        setObjects(objects);
    }

    public List<T> getObjects() {
        if (objects == null) {
            objects = new ChildList<>(this);
        }

        return objects;
    }

    public boolean isSetObjects() {
        return objects != null && !objects.isEmpty();
    }

    public void setObjects(List<T> objects) {
        this.objects = asChild(objects);
    }

    public void addObjectIfValid(Child object) {
        if (getTargetType().isInstance(object)) {
            getObjects().add(getTargetType().cast(object));
        }
    }
}
