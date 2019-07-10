package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.common.Enumeration;

public enum AggregationType implements Enumeration<AggregationType> {
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

    @Override
    public String toValue() {
        return value;
    }

    @Override
    public AggregationType fromValue(String value) {
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
