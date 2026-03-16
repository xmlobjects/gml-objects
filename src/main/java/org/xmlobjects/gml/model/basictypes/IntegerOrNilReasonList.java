/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

import java.util.List;

public class IntegerOrNilReasonList extends ValueOrNilReasonList<IntegerOrNilReason> {

    public IntegerOrNilReasonList() {
    }

    public IntegerOrNilReasonList(List<IntegerOrNilReason> value) {
        super(value);
    }
}
