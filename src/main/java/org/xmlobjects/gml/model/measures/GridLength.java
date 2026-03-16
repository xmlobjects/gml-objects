/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.measures;

import org.xmlobjects.gml.model.basictypes.Measure;

public class GridLength extends Measure {

    public GridLength() {
        super();
    }

    public GridLength(Double value) {
        super(value);
    }

    public GridLength(Double value, String uom) {
        super(value, uom);
    }
}
