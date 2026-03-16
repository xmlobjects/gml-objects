/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model;

import org.xmlobjects.model.Child;
import org.xmlobjects.model.ChildList;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class GMLObject implements Child, Serializable {
    private Child parent;

    protected final <T extends Child> T asChild(T child) {
        if (child != null) {
            child.setParent(this);
        }

        return child;
    }

    protected final <T extends Child> List<T> asChild(List<T> child) {
        if (child instanceof ChildList<T> childList) {
            childList.setParent(this);
            return child;
        } else {
            return child != null ? new ChildList<>(child, this) : null;
        }
    }

    @Override
    public final Child getParent() {
        return parent;
    }

    @Override
    public final void setParent(Child parent) {
        this.parent = parent;
    }

    public boolean unsetProperty(Object value) {
        return unsetProperty(value, false);
    }

    public boolean unsetProperty(Object value, boolean failOnError) {
        if (value == null) {
            return true;
        }

        Class<?> type = getClass();
        boolean removed = false;

        do {
            Field[] fields = type.getDeclaredFields();
            for (int i = 0; !removed && i < fields.length; i++) {
                try {
                    fields[i].setAccessible(true);
                    Object candidate = fields[i].get(this);
                    if (candidate == value) {
                        fields[i].set(this, null);
                        removed = true;
                    } else if (candidate instanceof Collection<?> collection) {
                        removed = collection.removeIf(v -> v == value);
                        if (removed && collection.isEmpty()) {
                            fields[i].set(this, null);
                        }
                    } else if (candidate instanceof Object[]) {
                        for (int j = 0; j < Array.getLength(candidate); j++) {
                            if (Array.get(candidate, j) == value) {
                                Array.set(candidate, j, null);
                                removed = true;
                            }
                        }
                    } else if (candidate instanceof Map<?, ?> map) {
                        removed = map.values().removeIf(v -> v == value);
                        if (removed && map.isEmpty()) {
                            fields[i].set(this, null);
                        }
                    }
                } catch (Throwable e) {
                    if (failOnError) {
                        throw new RuntimeException("Failed to unset property " + value + ".", e);
                    } else {
                        return false;
                    }
                }
            }
        } while (!removed && (type = type.getSuperclass()) != Object.class);

        return removed;
    }
}
