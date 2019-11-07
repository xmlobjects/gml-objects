package org.xmlobjects.gml.model.temporal;

import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;

public class ClockTime implements TimePositionValue<OffsetTime> {
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
}
