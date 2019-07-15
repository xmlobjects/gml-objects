package org.xmlobjects.gml.model.base;

public enum AggregationType {
    SET("set"),
    BAG("bag"),
    SEQUENCE("sequence"),
    ARRAY("array"),
    RECORD("record"),
    TABLE("table");

    private final String value;

    AggregationType(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static AggregationType fromValue(String value) {
        for (AggregationType v : AggregationType.values()) {
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
