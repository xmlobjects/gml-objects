package org.xmlobjects.gml.model.basictypes;

public enum NilReasonEnumeration {
    INAPPLICABLE("inapplicable"),
    MISSING("missing"),
    TEMPLATE("template"),
    UNKNOWN("unknown"),
    WITHHELD("withheld");

    private final String value;

    NilReasonEnumeration(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static NilReasonEnumeration fromValue(String value) {
        for (NilReasonEnumeration v : NilReasonEnumeration.values()) {
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
