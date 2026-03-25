/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.copy.CopyContext;
import org.xmlobjects.copy.CopyMode;
import org.xmlobjects.copy.Copyable;

import java.time.OffsetDateTime;

public class DateAndTime implements TimePositionValue<OffsetDateTime>, Copyable<DateAndTime> {
    private final OffsetDateTime dateTime;

    public DateAndTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public OffsetDateTime getValue() {
        return dateTime;
    }

    @Override
    public DateAndTime newInstance(CopyMode mode, CopyContext context) {
        return new DateAndTime(dateTime);
    }
}
