package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;

public abstract class PrimitiveOrNilReason<T> extends GMLObject {
    private T value;
    private NilReasonEnumeration nilReason;
    private String anyURI;

    PrimitiveOrNilReason() {
    }

    PrimitiveOrNilReason(T value) {
        this.value = value;
    }

    PrimitiveOrNilReason(NilReasonEnumeration nilReason) {
        this.nilReason = nilReason;
    }

    PrimitiveOrNilReason(String anyURI) {
        this.anyURI = anyURI;
    }

    public T getPrimitive() {
        return value;
    }

    void setPrimitive(T value) {
        this.value = value;
        nilReason = null;
        anyURI = null;
    }

    public NilReasonEnumeration getNilReason() {
        return nilReason;
    }

    public void setNilReason(NilReasonEnumeration nilReason) {
        this.nilReason = nilReason;
        value = null;
        anyURI = null;
    }

    public String getAnyURI() {
        return anyURI;
    }

    public void setAnyURI(String anyURI) {
        this.anyURI = anyURI;
        value = null;
        nilReason = null;
    }
}
