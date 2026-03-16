/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.CopyContext;
import org.xmlobjects.util.copy.Copyable;

public class OrdinalPosition implements TimePositionValue<String>, Copyable {
    private final String ordinalEra;

    public OrdinalPosition(String ordinalEra) {
        this.ordinalEra = ordinalEra;
    }

    @Override
    public String getValue() {
        return ordinalEra;
    }

    @Override
    public Copyable shallowCopy(CopyBuilder builder, CopyContext context) {
        return new OrdinalPosition(ordinalEra);
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder, CopyContext context) {
        return new OrdinalPosition(ordinalEra);
    }
}
