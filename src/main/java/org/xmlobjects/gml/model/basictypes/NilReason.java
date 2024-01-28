/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.util.GMLPatterns;

import java.net.URI;
import java.net.URISyntaxException;

public class NilReason extends GMLObject {
    private String value;

    public NilReason() {
    }

    public NilReason(NilReasonEnumeration value) {
        setValue(value);
    }

    public NilReason(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(NilReasonEnumeration value) {
        this.value = value.toValue();
    }

    public void setValue(String value) {
        if (NilReasonEnumeration.fromValue(value) != null || GMLPatterns.OTHER_VALUE.matcher(value).matches())
            this.value = value;
        else {
            try {
                URI uri = new URI(value);
                this.value = uri.toString();
            } catch (URISyntaxException e) {
                //
            }
        }
    }
}
