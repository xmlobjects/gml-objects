package org.xmlobjects.gml.model.basicTypes;

public class DoubleOrNilReason extends ValueOrNilReason<Double> {

    public DoubleOrNilReason() {
    }

    public DoubleOrNilReason(Double value) {
        super(value);
    }

    public DoubleOrNilReason(NilReason nilReason) {
        super(nilReason);
    }

    public DoubleOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public void setDouble(Double value) {
        setValue(value);
    }
}
