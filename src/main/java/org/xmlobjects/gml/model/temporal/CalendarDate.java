package org.xmlobjects.gml.model.temporal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class CalendarDate implements TimePositionValue<OffsetDateTime> {
    private OffsetDateTime date;
    private CalenderDateType type;

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
