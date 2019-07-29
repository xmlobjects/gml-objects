package org.xmlobjects.gml.model.basictypes;

public class NameOrNilReason extends ValueOrNilReason<String> {

    public NameOrNilReason() {
    }

    public NameOrNilReason(String value) {
        setValue(value);
    }

    public NameOrNilReason(NilReason nilReason) {
        super(nilReason);
    }

    public NameOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public void setName(String value) {
        setValue(value);
    }
}
