/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry;

import java.util.List;

public class Vector extends DirectPosition {

    public Vector() {
    }

    public Vector(List<Double> value) {
        super(value);
    }
}
