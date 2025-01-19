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

package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.NilReason;

public class Category extends Code implements AbstractScalarValue {
    private NilReason nilReason;

    public Category() {
    }

    public Category(String value) {
        super(value);
    }

    public Category(String value, String codeSpace) {
        super(value, codeSpace);
    }

    public boolean isSetValue() {
        return getValue() != null;
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
        nilReason = null;
    }

    public NilReason getNilReason() {
        return nilReason;
    }

    public boolean isSetNilReason() {
        return nilReason != null;
    }

    public void setNilReason(NilReason nilReason) {
        this.nilReason = asChild(nilReason);
        super.setValue(null);
        super.setCodeSpace(null);
    }
}
