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

package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class FeatureArrayProperty<T extends AbstractFeature> extends AbstractArrayProperty<T> {
    private List<GenericElement> genericElements;

    public FeatureArrayProperty() {
    }

    public FeatureArrayProperty(List<T> objects) {
        super(objects);
    }

    public List<GenericElement> getGenericElements() {
        if (genericElements == null)
            genericElements = new ChildList<>(this);

        return genericElements;
    }

    public boolean isSetGenericElements() {
        return genericElements != null && !genericElements.isEmpty();
    }

    public void setGenericElements(List<GenericElement> genericElements) {
        this.genericElements = asChild(genericElements);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractFeature.class;
    }
}
