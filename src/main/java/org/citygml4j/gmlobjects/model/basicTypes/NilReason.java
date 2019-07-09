package org.citygml4j.gmlobjects.model.basicTypes;

import org.citygml4j.gmlobjects.model.common.ModelObject;

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
