package org.xmlobjects.gml.model.coverage;

public enum SequenceRuleEnumeration {
    LINEAR("Linear"),
    BOUSTROPHEDONIC("Boustrophedonic"),
    CANTOR_DIAGONAL("Cantor-diagonal"),
    SPIRAL("Spiral"),
    MORTON("Morton"),
    HILBERT("Hilbert");

    private final String value;

    SequenceRuleEnumeration(String value) {
        this.value = value;
    }

    public String toValue() {
        return value;
    }

    public static SequenceRuleEnumeration fromValue(String value) {
        for (SequenceRuleEnumeration v : SequenceRuleEnumeration.values()) {
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
