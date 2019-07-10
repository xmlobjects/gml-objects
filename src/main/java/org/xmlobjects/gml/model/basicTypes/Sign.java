package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.common.Enumeration;

public enum Sign implements Enumeration<Sign> {
    PLUS("+"),
    MINUS("-");

    private final String value;

    Sign(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @Override
    public Sign fromValue(String value) {
        for (Sign v : Sign.values()) {
            if (v.value.equals(value))
                return v;
        }

        return PLUS;
    }

    @Override
    public String toString() {
        return value;
    }
}
