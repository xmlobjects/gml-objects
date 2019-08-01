package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.BooleanOrNilReason;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.basictypes.NilReasonEnumeration;

public class BooleanValue extends BooleanOrNilReason implements AbstractScalarValue {

    public BooleanValue() {
    }

    public BooleanValue(Boolean value) {
        super(value);
    }

    public BooleanValue(NilReason nilReason) {
        super(nilReason);
    }

    public BooleanValue(NilReasonEnumeration nilReason) {
        super(nilReason);
    }
}
