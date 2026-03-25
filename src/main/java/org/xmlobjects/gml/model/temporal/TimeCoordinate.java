/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.copy.CopyContext;
import org.xmlobjects.copy.CopyMode;
import org.xmlobjects.copy.Copyable;

public class TimeCoordinate implements TimePositionValue<Double>, Copyable<TimeCoordinate> {
    private final Double coordinate;

    public TimeCoordinate(Double coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public Double getValue() {
        return coordinate;
    }

    @Override
    public TimeCoordinate newInstance(CopyMode mode, CopyContext context) {
        return new TimeCoordinate(coordinate);
    }
}
