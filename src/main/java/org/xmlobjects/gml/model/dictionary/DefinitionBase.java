/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.dictionary;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.util.id.DefaultIdCreator;
import org.xmlobjects.gml.visitor.VisitableObject;

public abstract class DefinitionBase extends AbstractGML implements VisitableObject {

    public DefinitionBase() {
    }

    public DefinitionBase(CodeWithAuthority identifier) {
        setIdentifier(identifier);
    }

    @Override
    public String getId() {
        return super.getId() != null ?
                super.getId() :
                DefaultIdCreator.getInstance().createId();
    }
}
