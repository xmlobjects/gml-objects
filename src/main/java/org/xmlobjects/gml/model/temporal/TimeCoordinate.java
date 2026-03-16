/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.CopyContext;
import org.xmlobjects.util.copy.Copyable;

public class TimeCoordinate implements TimePositionValue<Double>, Copyable {
    private final Double coordinate;

    public TimeCoordinate(Double coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public Double getValue() {
        return coordinate;
    }

    @Override
    public Copyable shallowCopy(CopyBuilder builder, CopyContext context) {
        return new TimeCoordinate(coordinate);
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder, CopyContext context) {
        return new TimeCoordinate(coordinate);
    }
}
