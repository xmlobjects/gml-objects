/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.measures;

import org.xmlobjects.gml.model.basictypes.Measure;

public class Volume extends Measure {

    public Volume() {
        super();
    }

    public Volume(Double value) {
        super(value);
    }

    public Volume(Double value, String uom) {
        super(value, uom);
    }
}
