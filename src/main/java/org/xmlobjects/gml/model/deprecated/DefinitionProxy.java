/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.deprecated;

import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.dictionary.Definition;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class DefinitionProxy extends Definition {
    private Reference definitionRef;

    public DefinitionProxy() {
        super();
    }

    public DefinitionProxy(CodeWithAuthority identifier, Reference definitionRef) {
        super(identifier);
        setDefinitionRef(definitionRef);
    }

    public Reference getDefinitionRef() {
        return definitionRef;
    }

    public void setDefinitionRef(Reference definitionRef) {
        this.definitionRef = asChild(definitionRef);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
