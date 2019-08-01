package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.IntegerOrNilReason;
import org.xmlobjects.gml.model.basictypes.NilReason;
import org.xmlobjects.gml.model.basictypes.NilReasonEnumeration;

public class Count extends IntegerOrNilReason implements AbstractScalarValue {

    public Count() {
    }

    public Count(Integer value) {
        super(value);
    }

    public Count(NilReason nilReason) {
        super(nilReason);
    }

    public Count(NilReasonEnumeration nilReason) {
        super(nilReason);
    }
}
