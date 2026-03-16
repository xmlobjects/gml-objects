/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
