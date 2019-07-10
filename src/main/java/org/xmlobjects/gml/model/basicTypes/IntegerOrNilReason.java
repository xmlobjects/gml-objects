package org.xmlobjects.gml.model.basicTypes;

public class IntegerOrNilReason extends PrimitiveOrNilReason<Integer> {

    public IntegerOrNilReason() {
    }

    public IntegerOrNilReason(Integer value) {
        super(value);
    }

    public IntegerOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public IntegerOrNilReason(String anyURI) {
        super(anyURI);
    }

    public void setInteger(Integer value) {
        setPrimitive(value);
    }
}
