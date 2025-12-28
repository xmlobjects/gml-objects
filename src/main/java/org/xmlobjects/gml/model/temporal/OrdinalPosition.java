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

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.CopyContext;
import org.xmlobjects.util.copy.Copyable;

public class OrdinalPosition implements TimePositionValue<String>, Copyable {
    private final String ordinalEra;

    public OrdinalPosition(String ordinalEra) {
        this.ordinalEra = ordinalEra;
    }

    @Override
    public String getValue() {
        return ordinalEra;
    }

    @Override
    public Copyable shallowCopy(CopyBuilder builder, CopyContext context) {
        return new OrdinalPosition(ordinalEra);
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder, CopyContext context) {
        return new OrdinalPosition(ordinalEra);
    }
}
