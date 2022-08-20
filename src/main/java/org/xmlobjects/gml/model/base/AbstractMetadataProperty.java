/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2022 Claus Nagel <claus.nagel@gmail.com>
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

import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.model.Child;

public abstract class AbstractMetadataProperty<T extends Child> extends AbstractAssociation<T> implements OwnershipAttributes {
    private T object;
    private GenericElement genericElement;
    private Boolean owns;

    public AbstractMetadataProperty() {
    }

    public AbstractMetadataProperty(T object) {
        setObject(object);
    }

    public AbstractMetadataProperty(GenericElement element) {
        setGenericElement(element);
    }

    public T getObject() {
        return object;
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    public void setObject(T object) {
        this.object = asChild(object);
    }

    public void setObjectIfValid(Child object) {
        if (object == null || getTargetType().isInstance(object)) {
            setObject(getTargetType().cast(object));
        }
    }

    public GenericElement getGenericElement() {
        return genericElement;
    }

    public boolean isSetGenericElement() {
        return genericElement != null;
    }

    public void setGenericElement(GenericElement genericElement) {
        this.genericElement = asChild(genericElement);
    }

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }
}
