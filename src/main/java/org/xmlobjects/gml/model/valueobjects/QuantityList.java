/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.DoubleOrNilReason;
import org.xmlobjects.gml.model.basictypes.MeasureOrNilReasonList;

import java.util.List;

public class QuantityList extends MeasureOrNilReasonList implements AbstractScalarValueList {

    public QuantityList() {
    }

    public QuantityList(List<DoubleOrNilReason> value) {
        super(value);
    }

    public QuantityList(List<DoubleOrNilReason> value, String uom) {
        super(value, uom);
    }
}
