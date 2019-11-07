package org.xmlobjects.gml.model.temporal;

public enum TimeIndeterminateValue {
    AFTER("after"),
    BEFORE("before"),
    NOW("now"),
    UNKNOWN("unknown");

    private final String value;

    TimeIndeterminateValue(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static TimeIndeterminateValue fromValue(String value) {
        for (TimeIndeterminateValue v : TimeIndeterminateValue.values()) {
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
