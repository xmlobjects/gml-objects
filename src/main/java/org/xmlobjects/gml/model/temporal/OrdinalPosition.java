package org.xmlobjects.gml.model.temporal;

public class OrdinalPosition implements TimePositionValue<String> {
    private final String ordinalEra;

    public OrdinalPosition(String ordinalEra) {
        this.ordinalEra = ordinalEra;
    }

    @Override
    public String getValue() {
        return ordinalEra;
    }
}
