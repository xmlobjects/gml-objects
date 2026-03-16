/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.measures;

import org.xmlobjects.gml.model.basictypes.Measure;

public class Speed extends Measure {

    public Speed() {
        super();
    }

    public Speed(Double value) {
        super(value);
    }

    public Speed(Double value, String uom) {
        super(value, uom);
    }
}
