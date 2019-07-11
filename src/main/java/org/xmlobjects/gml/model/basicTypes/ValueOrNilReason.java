package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;

public abstract class ValueOrNilReason<T> extends GMLObject {
    private T value;
    private NilReasonEnumeration nilReason;
    private String anyURI;

    ValueOrNilReason() {
    }

    ValueOrNilReason(T value) {
        this.value = value;
    }

    ValueOrNilReason(NilReasonEnumeration nilReason) {
        this.nilReason = nilReason;
    }

    ValueOrNilReason(String anyURI) {
        this.anyURI = anyURI;
    }

    public T getValue() {
        return value;
    }

    public boolean isSetValue() {
        return value != null;
    }

    void setValue(T value) {
        this.value = value;
        nilReason = null;
        anyURI = null;
    }

    public NilReasonEnumeration getNilReason() {
        return nilReason;
    }

    public boolean isSetNilReason() {
        return nilReason != null;
    }

    public void setNilReason(NilReasonEnumeration nilReason) {
        this.nilReason = nilReason;
        value = null;
        anyURI = null;
    }

    public String getAnyURI() {
        return anyURI;
    }

    public boolean isSetAnyURI() {
        return anyURI != null;
    }

    public void setAnyURI(String anyURI) {
        this.anyURI = anyURI;
        value = null;
        nilReason = null;
    }
}
