package org.xmlobjects.gml.model.xlink;

import org.xmlobjects.gml.model.common.Enumeration;

public enum ActuateType implements Enumeration<ActuateType> {
    ON_LOAD("onLoad"),
    ON_REQUEST("onRequest"),
    OTHER("other"),
    NONE("none");

    private final String value;

    ActuateType(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @Override
    public ActuateType fromValue(String value) {
        for (ActuateType v : ActuateType.values()) {
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
