package org.xmlobjects.gml.model.basicTypes;

public class NameOrNilReason extends PrimitiveOrNilReason<String> {

    public NameOrNilReason() {
    }

    public NameOrNilReason(NilReasonEnumeration nilReason) {
        super(nilReason);
    }

    public void setName(String value) {
        super.setPrimitive(value);
    }
}
