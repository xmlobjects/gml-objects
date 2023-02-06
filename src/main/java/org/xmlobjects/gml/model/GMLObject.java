/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.model;

import org.xmlobjects.model.Child;
import org.xmlobjects.model.ChildList;
import org.xmlobjects.util.copy.Copyable;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class GMLObject implements Child, Copyable {
    private Child parent;

    protected final <T extends Child> T asChild(T child) {
        if (child != null) {
            child.setParent(this);
        }

        return child;
    }

    protected final <T extends Child> List<T> asChild(List<T> child) {
        if (child instanceof ChildList) {
            ((ChildList<T>) child).setParent(this);
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
                    } else if (candidate instanceof Collection) {
                        removed = ((Collection<?>) candidate).removeIf(v -> v == value);
                        if (removed && ((Collection<?>) candidate).isEmpty()) {
                            fields[i].set(this, null);
                        }
                    } else if (candidate instanceof Object[]) {
                        for (int j = 0; j < Array.getLength(candidate); j++) {
                            if (Array.get(candidate, j) == value) {
                                Array.set(candidate, j, null);
                                removed = true;
                            }
                        }
                    } else if (candidate instanceof Map) {
                        removed = ((Map<?, ?>) candidate).values().removeIf(v -> v == value);
                        if (removed && ((Map<?, ?>) candidate).isEmpty()) {
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
