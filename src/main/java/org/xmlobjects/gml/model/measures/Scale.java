/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.measures;

import org.xmlobjects.gml.model.basictypes.Measure;

public class Scale extends Measure {

    public Scale() {
        super();
    }

    public Scale(Double value) {
        super(value);
    }

    public Scale(Double value, String uom) {
        super(value, uom);
    }
}
