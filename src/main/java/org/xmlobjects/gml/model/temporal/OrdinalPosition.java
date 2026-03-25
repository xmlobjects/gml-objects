/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.copy.CopyContext;
import org.xmlobjects.copy.CopyMode;
import org.xmlobjects.copy.Copyable;

public class OrdinalPosition implements TimePositionValue<String>, Copyable<OrdinalPosition> {
    private final String ordinalEra;

    public OrdinalPosition(String ordinalEra) {
        this.ordinalEra = ordinalEra;
    }

    @Override
    public String getValue() {
        return ordinalEra;
    }

    @Override
    public OrdinalPosition newInstance(CopyMode mode, CopyContext context) {
        return new OrdinalPosition(ordinalEra);
    }
}
