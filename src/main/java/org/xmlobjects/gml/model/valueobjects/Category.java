package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.NilReason;

public class Category extends Code implements AbstractScalarValue {
    private NilReason nilReason;

    public Category() {
    }

    public Category(String value) {
        super(value);
    }

    public Category(String value, String codeSpace) {
        super(value, codeSpace);
    }

    public boolean isSetValue() {
        return getValue() != null;
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
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
        super.setValue(null);
        super.setCodeSpace(null);
    }
}
