/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.basictypes;

import java.util.List;

public class CodeOrNilReasonList extends NameOrNilReasonList {
    private String codeSpace;

    public CodeOrNilReasonList() {
    }

    public CodeOrNilReasonList(List<NameOrNilReason> value) {
        super(value);
    }

    public CodeOrNilReasonList(List<NameOrNilReason> value, String codeSpace) {
        this(value);
        this.codeSpace = codeSpace;
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
