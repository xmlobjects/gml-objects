/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.base;

public class Reference extends AbstractReference<AbstractGML> {

    public Reference() {
    }

    public Reference(String href) {
        super(href);
    }

    public Reference(AbstractGML object) {
        super(object);
    }

    public Reference(AssociationAttributes reference) {
        super(reference);
    }

    @Override
    public Class<AbstractGML> getTargetType() {
        return AbstractGML.class;
    }
}
