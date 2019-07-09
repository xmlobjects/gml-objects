package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.common.Enumeration;

public enum NilReasonEnumeration implements Enumeration {
    INAPPLICABLE("inapplicable"),
    MISSING("missing"),
    TEMPLATE("template"),
    UNKNOWN("unknown"),
    WITHHELD("withheld");

    private final String value;

    NilReasonEnumeration(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @Override
    public NilReasonEnumeration fromValue(String value) {
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
