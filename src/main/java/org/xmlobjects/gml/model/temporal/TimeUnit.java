package org.xmlobjects.gml.model.temporal;

public enum TimeUnit {
    YEAR("year"),
    MONTH("month"),
    DAY("day"),
    HOUR("hour"),
    MINUTE("minute"),
    SECOND("second");

    private final String value;

    TimeUnit(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static TimeUnit fromValue(String value) {
        for (TimeUnit v : TimeUnit.values()) {
            if (v.value.equals(value))
                return v;
        }

        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
