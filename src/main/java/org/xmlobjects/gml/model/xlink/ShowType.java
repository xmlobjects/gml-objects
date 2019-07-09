package org.xmlobjects.gml.model.xlink;

import org.xmlobjects.gml.model.common.Enumeration;

public enum ShowType implements Enumeration {
    NEW("new"),
    REPLACE("replace"),
    EMBED("embed"),
    OTHER("other"),
    NONE("none");

    private final String value;

    ShowType(String value) {
        this.value = value;
    }

    @Override
    public String toValue() {
        return value;
    }

    @Override
    public ShowType fromValue(String value) {
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
