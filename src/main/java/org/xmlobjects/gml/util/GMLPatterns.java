/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
