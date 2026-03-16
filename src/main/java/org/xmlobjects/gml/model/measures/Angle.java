/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.measures;

import org.xmlobjects.gml.model.basictypes.Measure;

public class Angle extends Measure {

    public Angle() {
        super();
    }

    public Angle(Double value) {
        super(value);
    }

    public Angle(Double value, String uom) {
        super(value, uom);
    }
}
