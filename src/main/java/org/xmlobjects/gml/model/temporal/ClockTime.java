/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.copy.CopyContext;
import org.xmlobjects.copy.CopyMode;
import org.xmlobjects.copy.Copyable;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class ClockTime implements TimePositionValue<OffsetTime>, Copyable<ClockTime> {
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
    public ClockTime newInstance(CopyMode mode, CopyContext context) {
        return new ClockTime(clockTime);
    }
}
