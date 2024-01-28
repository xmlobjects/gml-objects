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

package org.xmlobjects.gml.model.coverage;

import java.util.Arrays;
import java.util.List;

public enum IncrementOrder {
    PLUS_X_PLUS_Y("+x+y", new String[]{"+1", "+2"}),
    PLUS_Y_PLUS_X("+y+x", new String[]{"+2", "+1"}),
    PLUS_X_MINUS_Y("+x-y", new String[]{"+1", "-2"}),
    MINUS_X_MINUS_Y("-x-y", new String[]{"-1", "-2"});

    private final String value;
    private final String[] axisOrders;

    IncrementOrder(String value, String[] axisOrders) {
        this.value = value;
        this.axisOrders = axisOrders;
    }

    public String toValue() {
        return value;
    }

    public List<String> getAsAxisOrders() {
        return Arrays.asList(axisOrders);
    }

    public static IncrementOrder fromValue(String value) {
        for (IncrementOrder v : IncrementOrder.values()) {
            if (v.value.equals(value))
                return v;
        }

        return null;
    }

    public static IncrementOrder fromAxisOrders(List<String> axisOrders) {
        if (axisOrders.size() > 1) {
            for (IncrementOrder v : IncrementOrder.values()) {
                if (v.axisOrders[0].equals(axisOrders.get(0)) && v.axisOrders[1].equals(axisOrders.get(1))) {
                    for (int i = 2; i < axisOrders.size(); i++) {
                        if (!axisOrders.get(i).startsWith("+"))
                            return null;
                    }

                    return v;
                }
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
