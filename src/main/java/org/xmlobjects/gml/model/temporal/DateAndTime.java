/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.CopyContext;
import org.xmlobjects.util.copy.Copyable;

import java.time.OffsetDateTime;

public class DateAndTime implements TimePositionValue<OffsetDateTime>, Copyable {
    private final OffsetDateTime dateTime;

    public DateAndTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public OffsetDateTime getValue() {
        return dateTime;
    }

    @Override
    public Copyable shallowCopy(CopyBuilder builder, CopyContext context) {
        return new DateAndTime(dateTime);
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder, CopyContext context) {
        return new DateAndTime(dateTime);
    }
}
