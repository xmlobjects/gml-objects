package org.xmlobjects.gml.model.temporal;

public enum RelativePosition {
    BEFORE("Before"),
    AFTER("After"),
    BEGINS("Begins"),
    ENDS("Ends"),
    DURING("During"),
    EQUALS("Equals"),
    CONTAINS("Contains"),
    OVERLAPS("Overlaps"),
    MEETS("Meets"),
    OVERLAPPED_BY("OverlappedBy"),
    MET_BY("MetBy"),
    BEGUN_BY("BegunBy"),
    ENDED_BY("EndedBy");

    private final String value;

    RelativePosition(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static RelativePosition fromValue(String value) {
        for (RelativePosition v : RelativePosition.values()) {
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
