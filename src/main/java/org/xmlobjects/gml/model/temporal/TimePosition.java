package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.xml.TextContent;

public class TimePosition extends GMLObject {
    private TimePositionValue value;
    private String frame;
    private String calendarEraName;
    private TimeIndeterminateValue indeterminatePosition;

    public TimePosition() {
    }

    public TimePosition(TimePositionValue value) {
        this.value = value;
    }

    public TimePosition(String value) {
        setValue(value);
    }

    public TimePositionValue getValue() {
        return value;
    }

    public void setValue(TimePositionValue value) {
        this.value = value;
    }

    public void setValue(String value) {
        TextContent content = TextContent.of(value);
        if (content.isDateTime())
            this.value = new DateAndTime(content.getAsDateTime());
        else if (content.isTime())
            this.value = new ClockTime(content.getAsTime().toOffsetTime());
        else if (content.isDate())
            this.value = new CalendarDate(content.getAsDate(), CalenderDateType.DATE);
        else if (content.isGYear())
            this.value = new CalendarDate(content.getAsGYear(), CalenderDateType.YEAR);
        else if (content.isGYearMonth())
            this.value = new CalendarDate(content.getAsGYearMonth(), CalenderDateType.YEAR_MONTH);
        else if (content.isDouble())
            this.value = new TimeCoordinate(content.getAsDouble());
        else
            this.value = new OrdinalPosition(value);
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
