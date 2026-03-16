/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.dictionary;

import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class Definition extends DefinitionBase {
    private String remarks;

    public Definition() {
        super();
    }

    public Definition(CodeWithAuthority identifier) {
        super(identifier);
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
