/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.CopyContext;
import org.xmlobjects.util.copy.Copyable;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class ClockTime implements TimePositionValue<OffsetTime>, Copyable {
    private final OffsetTime clockTime;

    public ClockTime(OffsetTime clockTime) {
        this.clockTime = clockTime;
    }

    public ClockTime(LocalTime clockTime) {
        this.clockTime = OffsetTime.of(clockTime, ZoneOffset.UTC);
    }

    @Override
    public OffsetTime getValue() {
        return clockTime;
    }

    @Override
    public Copyable shallowCopy(CopyBuilder builder, CopyContext context) {
        return new ClockTime(clockTime);
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder, CopyContext context) {
        return new ClockTime(clockTime);
    }
}
