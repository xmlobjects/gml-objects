package org.xmlobjects.gml.model.coverage;

public enum FileValueModel {
    RECORD_INTERLEAVED("Record Interleaved");

    private final String value;

    FileValueModel(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static FileValueModel fromValue(String value) {
        for (FileValueModel v : FileValueModel.values()) {
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
