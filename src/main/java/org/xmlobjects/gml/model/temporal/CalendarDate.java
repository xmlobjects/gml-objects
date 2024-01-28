/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.temporal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class CalendarDate implements TimePositionValue<OffsetDateTime> {
    private final OffsetDateTime date;
    private final CalenderDateType type;

    public CalendarDate(OffsetDateTime date, CalenderDateType type) {
        this.date = date;
        this.type = type;
    }

    private static CalendarDate ofDate(OffsetDateTime date, CalenderDateType type) {
        return new CalendarDate(date, type);
    }

    private static CalendarDate ofDate(LocalDate date, CalenderDateType type) {
        return new CalendarDate(OffsetDateTime.of(date, LocalTime.MIN, ZoneOffset.UTC), type);
    }

    public static CalendarDate ofDate(OffsetDateTime date) {
        return ofDate(date, CalenderDateType.DATE);
    }

    public static CalendarDate ofDate(LocalDate date) {
        return ofDate(date, CalenderDateType.DATE);
    }

    public static CalendarDate ofYear(OffsetDateTime date) {
        return ofDate(date, CalenderDateType.YEAR);
    }

    public static CalendarDate ofYear(LocalDate date) {
        return ofDate(date, CalenderDateType.YEAR);
    }

    public static CalendarDate ofYearMonth(OffsetDateTime date) {
        return ofDate(date, CalenderDateType.YEAR_MONTH);
    }

    public static CalendarDate ofYearMonth(LocalDate date) {
        return ofDate(date, CalenderDateType.YEAR_MONTH);
    }

    @Override
    public OffsetDateTime getValue() {
        return date;
    }

    public CalenderDateType getType() {
        return type;
    }

    public boolean isDate() {
        return type == CalenderDateType.DATE;
    }

    public boolean isYear() {
        return type == CalenderDateType.YEAR;
    }

    public boolean isYearMonth() {
        return type == CalenderDateType.YEAR_MONTH;
    }
}
