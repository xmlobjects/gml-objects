/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.dictionary;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class DefinitionProperty extends AbstractProperty<Definition> {

    public DefinitionProperty() {
    }

    public DefinitionProperty(Definition definition) {
        super(definition);
    }

    public DefinitionProperty(String href) {
        super(href);
    }

    @Override
    public Class<Definition> getTargetType() {
        return Definition.class;
    }
}
