package org.xmlobjects.gml.model.xlink;

public enum ActuateType {
    ON_LOAD("onLoad"),
    ON_REQUEST("onRequest"),
    OTHER("other"),
    NONE("none");

    private final String value;

    ActuateType(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static ActuateType fromValue(String value) {
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
