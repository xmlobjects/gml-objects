package org.xmlobjects.gml.model.xlink;

public enum ShowType {
    NEW("new"),
    REPLACE("replace"),
    EMBED("embed"),
    OTHER("other"),
    NONE("none");

    private final String value;

    ShowType(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static ShowType fromValue(String value) {
        for (ShowType v : ShowType.values()) {
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
