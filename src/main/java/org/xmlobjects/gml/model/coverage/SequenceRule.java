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

package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.List;

public class SequenceRule extends GMLObject {
    private SequenceRuleEnumeration value;
    private List<String> axisOrders;

    public SequenceRule() {
    }

    public SequenceRule(SequenceRuleEnumeration value) {
        this.value = value;
    }

    public SequenceRuleEnumeration getValue() {
        return value != null ? value : SequenceRuleEnumeration.LINEAR;
    }

    public void setValue(SequenceRuleEnumeration value) {
        this.value = value;
    }

    public List<String> getAxisOrders() {
        if (axisOrders == null)
            axisOrders = new ArrayList<>();

        return axisOrders;
    }

    public boolean isSetAxisOrders() {
        return axisOrders != null && !axisOrders.isEmpty();
    }

    public void setAxisOrders(List<String> axisOrders) {
        this.axisOrders = axisOrders;
    }

    public void setAxisOrders(IncrementOrder order) {
        axisOrders = order != null ? order.getAsAxisOrders() : null;
    }
}
