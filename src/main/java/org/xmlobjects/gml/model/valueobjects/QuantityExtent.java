package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.DoubleOrNilReason;
import org.xmlobjects.gml.model.basictypes.MeasureOrNilReasonList;

import java.util.List;

public class QuantityExtent extends MeasureOrNilReasonList implements AbstractValue {

    public QuantityExtent() {
    }

    public QuantityExtent(List<DoubleOrNilReason> value) {
        super(value);
    }

    public QuantityExtent(List<DoubleOrNilReason> value, String uom) {
        super(value, uom);
    }
}
