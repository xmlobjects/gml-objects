/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2021 Claus Nagel <claus.nagel@gmail.com>
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
