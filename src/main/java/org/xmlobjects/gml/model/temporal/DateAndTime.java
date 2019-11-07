package org.xmlobjects.gml.model.temporal;

import java.time.OffsetDateTime;

public class DateAndTime implements TimePositionValue<OffsetDateTime> {
    private final OffsetDateTime dateTime;

    public DateAndTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public OffsetDateTime getValue() {
        return dateTime;
    }
}
