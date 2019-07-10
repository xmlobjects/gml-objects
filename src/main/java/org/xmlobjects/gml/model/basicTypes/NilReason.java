package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;

public class NilReason extends GMLObject {
    private String value;

    public NilReason() {
    }

    public NilReason(NilReasonEnumeration value) {
        this.value = value.toValue();
    }

    public NilReason(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(NilReasonEnumeration value) {
        this.value = value != null ? value.toValue() : null;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
