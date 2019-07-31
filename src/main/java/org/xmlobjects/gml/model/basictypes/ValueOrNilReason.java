package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;

public abstract class ValueOrNilReason<T> extends GMLObject {
    private T value;
    private NilReason nilReason;

    ValueOrNilReason() {
    }

    ValueOrNilReason(T value) {
        this.value = value;
    }

    ValueOrNilReason(NilReason nilReason) {
        setNilReason(nilReason);
    }

    ValueOrNilReason(NilReasonEnumeration nilReason) {
        setNilReason(new NilReason(nilReason));
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
    }

    public NilReason getNilReason() {
        return nilReason;
    }

    public boolean isSetNilReason() {
        return nilReason != null;
    }

    public void setNilReason(NilReason nilReason) {
        this.nilReason = asChild(nilReason);
        value = null;
    }
}
