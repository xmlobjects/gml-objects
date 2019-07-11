package org.xmlobjects.gml.model.basicTypes;

public class StringOrNilReason extends ValueOrNilReason<String> {

    public StringOrNilReason() {
    }

    public StringOrNilReason(String value) {
        setValue(value);
    }

    public StringOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public void setString(String value) {
        setValue(value);
    }
}
