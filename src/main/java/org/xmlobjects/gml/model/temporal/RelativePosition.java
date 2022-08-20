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

package org.xmlobjects.gml.model.temporal;

public enum RelativePosition {
    BEFORE("Before"),
    AFTER("After"),
    BEGINS("Begins"),
    ENDS("Ends"),
    DURING("During"),
    EQUALS("Equals"),
    CONTAINS("Contains"),
    OVERLAPS("Overlaps"),
    MEETS("Meets"),
    OVERLAPPED_BY("OverlappedBy"),
    MET_BY("MetBy"),
    BEGUN_BY("BegunBy"),
    ENDED_BY("EndedBy");

    private final String value;

    RelativePosition(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static RelativePosition fromValue(String value) {
        for (RelativePosition v : RelativePosition.values()) {
            if (v.value.equals(value))
                return v;
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
