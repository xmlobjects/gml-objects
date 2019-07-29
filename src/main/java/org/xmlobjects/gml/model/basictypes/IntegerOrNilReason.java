package org.xmlobjects.gml.model.basictypes;

public class IntegerOrNilReason extends ValueOrNilReason<Integer> {

    public IntegerOrNilReason() {
    }

    public IntegerOrNilReason(Integer value) {
        super(value);
    }

    public IntegerOrNilReason(NilReason nilReason) {
        super(nilReason);
    }

    public IntegerOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public void setInteger(Integer value) {
        setValue(value);
    }
}
