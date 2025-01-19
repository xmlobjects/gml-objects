/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.common.GenericElement;

public abstract class AbstractFeatureMember<T extends AbstractFeature> extends AbstractInlineProperty<T> {
    private GenericElement genericElement;

    public AbstractFeatureMember() {
    }

    public AbstractFeatureMember(T object) {
        super(object);
    }

    public AbstractFeatureMember(GenericElement element) {
        setGenericElement(element);
    }

    @Override
    public T getObject() {
        return super.getObject();
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    @Override
    public void setObject(T object) {
        super.setObject(object);
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
}
