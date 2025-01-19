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

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.xml.TextContent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimePosition extends GMLObject {
    private TimePositionValue<?> value;
    private String frame;
    private String calendarEraName;
    private TimeIndeterminateValue indeterminatePosition;

    public TimePosition() {
    }

    public TimePosition(TimePositionValue<?> value) {
        this.value = value;
    }

    public TimePosition(String value) {
        setValue(value);
    }

    public TimePositionValue<?> getValue() {
        return value;
    }

    public void setValue(TimePositionValue<?> value) {
        this.value = value;
    }

    public void setValue(String value) {
        TextContent content = TextContent.of(value);
        if (content.isDateTime()) {
            this.value = new DateAndTime(content.getAsDateTime());
        } else if (content.isTime()) {
            this.value = new ClockTime(content.getAsTime().toLocalTime());
        } else if (content.isDate()) {
            this.value = new CalendarDate(content.getAsDate(), CalenderDateType.DATE);
        } else if (content.isGYear()) {
            this.value = new CalendarDate(content.getAsGYear(), CalenderDateType.YEAR);
        } else if (content.isGYearMonth()) {
            this.value = new CalendarDate(content.getAsGYearMonth(), CalenderDateType.YEAR_MONTH);
        } else if (content.isDouble()) {
            this.value = new TimeCoordinate(content.getAsDouble());
        } else {
            try {
                LocalDate date = LocalDate.parse(value, DateTimeFormatter.ISO_WEEK_DATE);
                this.value = new CalendarDate(TextContent.of(date.toString()).getAsDate(), CalenderDateType.DATE);
            } catch (DateTimeParseException e) {
                this.value = new OrdinalPosition(value);
            }
        }
    }

    public String getFrame() {
        return frame != null ? frame : "#ISO-8601";
    }

    public boolean isSetFrame() {
        return frame != null;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getCalendarEraName() {
        return calendarEraName;
    }

    public void setCalendarEraName(String calendarEraName) {
        this.calendarEraName = calendarEraName;
    }

    public TimeIndeterminateValue getIndeterminatePosition() {
        return indeterminatePosition;
    }

    public void setIndeterminatePosition(TimeIndeterminateValue indeterminatePosition) {
        this.indeterminatePosition = indeterminatePosition;
    }

    public CalendarDate asCalendarDate() {
        return isCalendarDate() ? (CalendarDate) value : null;
    }

    public boolean isCalendarDate() {
        return value instanceof CalendarDate;
    }

    public ClockTime asClockTime() {
        return isClockTime() ? (ClockTime) value : null;
    }

    public boolean isClockTime() {
        return value instanceof ClockTime;
    }

    public DateAndTime asDateAndTime() {
        return isDateAndTime() ? (DateAndTime) value : null;
    }

    public boolean isDateAndTime() {
        return value instanceof DateAndTime;
    }

    public OrdinalPosition asOrdinalPosition() {
        return isOrdinalPosition() ? (OrdinalPosition) value : null;
    }

    public boolean isOrdinalPosition() {
        return value instanceof OrdinalPosition;
    }

    public TimeCoordinate asTimeCoordinate() {
        return isTimeCoordinate() ? (TimeCoordinate) value : null;
    }

    public boolean isTimeCoordinate() {
        return value instanceof TimeCoordinate;
    }
}
