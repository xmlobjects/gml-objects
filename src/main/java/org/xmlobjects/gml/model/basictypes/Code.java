/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

public class Code extends LanguageString {
    private String codeSpace;

    public Code() {
    }

    public Code(String value) {
        super(value);
    }

    public Code(String value, String codeSpace) {
        super(value);
        this.codeSpace = codeSpace;
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
