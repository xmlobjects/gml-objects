/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.measures;

import org.xmlobjects.gml.model.basictypes.Measure;

public class Length extends Measure {

    public Length() {
        super();
    }

    public Length(Double value) {
        super(value);
    }

    public Length(Double value, String uom) {
        super(value, uom);
    }
}
