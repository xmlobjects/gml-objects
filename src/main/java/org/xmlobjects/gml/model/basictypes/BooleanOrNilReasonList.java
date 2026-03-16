/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

import java.util.List;

public class BooleanOrNilReasonList extends ValueOrNilReasonList<BooleanOrNilReason> {

    public BooleanOrNilReasonList() {
    }

    public BooleanOrNilReasonList(List<BooleanOrNilReason> value) {
        super(value);
    }
}
