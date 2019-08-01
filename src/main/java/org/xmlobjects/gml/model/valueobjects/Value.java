package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public class Value extends GMLObject {
    private AbstractValue value;
    private AbstractGeometry geometry;
    private NilReason nullReason;

    public Value() {
    }

    public Value(AbstractValue value) {
        setValue(value);
    }

    public Value(AbstractGeometry geometry) {
        setGeometry(geometry);
    }

    public AbstractValue getValue() {
        return value;
    }

    public boolean isSetValue() {
        return value != null;
    }

    public void setValue(AbstractValue value) {
        this.value = asChild(value);
        geometry = null;
        nullReason = null;
    }


    public AbstractGeometry getGeometry() {
        return geometry;
    }

    public boolean isSetGeometry() {
        return geometry != null;
    }

    public void setGeometry(AbstractGeometry geometry) {
        this.geometry = asChild(geometry);
        value = null;
        nullReason = null;
    }

    public NilReason getNull() {
        return nullReason;
    }

    public boolean isSetNull() {
        return nullReason != null;
    }

    public void setNull(NilReason nullReason) {
        this.nullReason = asChild(nullReason);
        value = null;
        geometry = null;
    }
}
