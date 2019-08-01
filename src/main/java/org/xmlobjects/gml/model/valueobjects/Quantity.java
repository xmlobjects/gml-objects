package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.Measure;
import org.xmlobjects.gml.model.basictypes.NilReason;

public class Quantity extends Measure implements AbstractScalarValue {
    private NilReason nilReason;

    public Quantity() {
    }

    public Quantity(Double value) {
        super(value);
    }

    public Quantity(Double value, String uom) {
        super(value, uom);
    }

    public boolean isSetValue() {
        return getValue() != null;
    }

    @Override
    public void setValue(Double value) {
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
        super.setUom(null);
    }
}
