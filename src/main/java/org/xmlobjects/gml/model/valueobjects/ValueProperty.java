/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class ValueProperty extends AbstractProperty<Value> {

    public ValueProperty() {
    }

    public ValueProperty(Value object) {
        super(object);
    }

    public ValueProperty(String href) {
        super(href);
    }

    @Override
    public Class<Value> getTargetType() {
        return Value.class;
    }
}
