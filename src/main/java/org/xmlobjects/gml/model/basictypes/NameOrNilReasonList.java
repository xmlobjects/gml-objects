/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

import java.util.List;

public class NameOrNilReasonList extends ValueOrNilReasonList<NameOrNilReason> {

    public NameOrNilReasonList() {
    }

    public NameOrNilReasonList(List<NameOrNilReason> value) {
        super(value);
    }
}
