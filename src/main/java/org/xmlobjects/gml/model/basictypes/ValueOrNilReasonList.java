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

package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class ValueOrNilReasonList<T extends ValueOrNilReason<?>> extends GMLObject {
    private List<T> value;

    public ValueOrNilReasonList() {
    }

    public ValueOrNilReasonList(List<T> value) {
        setValue(value);
    }

    public List<T> getValue() {
        if (value == null)
            value = new ChildList<>(this);

        return value;
    }

    public boolean isSetValue() {
        return value != null && !value.isEmpty();
    }

    public void setValue(List<T> value) {
        this.value = asChild(value);
    }
}
