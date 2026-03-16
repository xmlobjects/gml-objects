/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

public class CodeWithAuthority extends Code {

    public CodeWithAuthority() {
    }

    public CodeWithAuthority(String value) {
        super(value);
    }

    public CodeWithAuthority(String value, String codeSpace) {
        super(value, codeSpace);
    }
}
