/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.measures;

import org.xmlobjects.gml.model.basictypes.Measure;

public class Area extends Measure {

    public Area() {
        super();
    }

    public Area(Double value) {
        super(value);
    }

    public Area(Double value, String uom) {
        super(value, uom);
    }
}
