package org.xmlobjects.gml.model.basicTypes;

public class StringOrNilReason extends PrimitiveOrNilReason<String> {

    public StringOrNilReason() {
    }

    public StringOrNilReason(String value) {
        setPrimitive(value);
    }

    public StringOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public void setString(String value) {
        setPrimitive(value);
    }
}
