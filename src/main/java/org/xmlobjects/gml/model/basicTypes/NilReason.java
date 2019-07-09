package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.common.ModelObject;

public class NilReason extends ModelObject {
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
}
