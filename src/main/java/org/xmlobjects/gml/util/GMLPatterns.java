/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.util;

import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.format.SignStyle;
import java.time.temporal.IsoFields;
import java.util.regex.Pattern;

import static java.time.temporal.ChronoField.*;

public class GMLPatterns {
    public static final Pattern UOM_SYMBOL = Pattern.compile("[^: \\n\\r\\t]+");
    public static final Pattern UOM_URI = Pattern.compile("([a-zA-Z][a-zA-Z0-9\\-+.]*:|\\.\\./|\\./|#).*");
    public static final Pattern AXIS_DIRECTION = Pattern.compile("[+\\-][1-9][0-9]*");
    public static final Pattern OTHER_VALUE = Pattern.compile("other:\\w{2,}");

    public static final DateTimeFormatter ISO_WEEK_DATE = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendValue(IsoFields.WEEK_BASED_YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
            .optionalStart()
            .appendLiteral('-')
            .optionalEnd()
            .appendLiteral('W')
            .appendValue(IsoFields.WEEK_OF_WEEK_BASED_YEAR, 2)
            .optionalStart()
            .appendLiteral('-')
            .optionalEnd()
            .appendValue(DAY_OF_WEEK, 1)
            .optionalStart()
            .appendOffsetId()
            .toFormatter()
            .withResolverStyle(ResolverStyle.STRICT)
            .withChronology(IsoChronology.INSTANCE);

    public static final DateTimeFormatter ISO_TIME = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendLiteral('T')
            .appendValue(HOUR_OF_DAY, 2)
            .optionalStart()
            .optionalStart()
            .appendLiteral(':')
            .optionalEnd()
            .appendValue(MINUTE_OF_HOUR, 2)
            .optionalStart()
            .optionalStart()
            .appendLiteral(':')
            .optionalEnd()
            .appendValue(SECOND_OF_MINUTE, 2)
            .optionalStart()
            .appendFraction(NANO_OF_SECOND, 0, 9, true)
            .optionalStart()
            .appendOffsetId()
            .toFormatter()
            .withResolverStyle(ResolverStyle.LENIENT);
}
