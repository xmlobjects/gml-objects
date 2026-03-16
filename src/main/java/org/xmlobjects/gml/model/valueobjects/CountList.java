/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.IntegerOrNilReason;
import org.xmlobjects.gml.model.basictypes.IntegerOrNilReasonList;

import java.util.List;

public class CountList extends IntegerOrNilReasonList implements AbstractScalarValueList {

    public CountList() {
    }

    public CountList(List<IntegerOrNilReason> value) {
        super(value);
    }
}
