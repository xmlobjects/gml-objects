package org.xmlobjects.gml.model.basictypes;

public class BooleanOrNilReason extends ValueOrNilReason<Boolean> {

    public BooleanOrNilReason() {
    }

    public BooleanOrNilReason(Boolean value) {
        super(value);
    }

    public BooleanOrNilReason(NilReason nilReason) {
        super(nilReason);
    }

    public BooleanOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }
}
