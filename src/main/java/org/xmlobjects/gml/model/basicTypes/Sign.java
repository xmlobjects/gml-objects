package org.xmlobjects.gml.model.basicTypes;

public enum Sign {
    PLUS("+"),
    MINUS("-");

    private final String value;

    Sign(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static Sign fromValue(String value) {
        for (Sign v : Sign.values()) {
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
