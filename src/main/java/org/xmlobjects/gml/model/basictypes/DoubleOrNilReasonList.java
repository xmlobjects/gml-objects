/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

import java.util.List;

public class DoubleOrNilReasonList extends ValueOrNilReasonList<DoubleOrNilReason> {

    public DoubleOrNilReasonList() {
    }

    public DoubleOrNilReasonList(List<DoubleOrNilReason> value) {
        super(value);
    }
}
