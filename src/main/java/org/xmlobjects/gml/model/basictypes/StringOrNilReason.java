/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

public class StringOrNilReason extends ValueOrNilReason<String> {

    public StringOrNilReason() {
    }

    public StringOrNilReason(String value) {
        setValue(value);
    }

    public StringOrNilReason(NilReason nilReason) {
        super(nilReason);
    }

    public StringOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }
}
