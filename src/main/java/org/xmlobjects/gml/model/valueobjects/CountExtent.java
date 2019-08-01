package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.IntegerOrNilReason;
import org.xmlobjects.gml.model.basictypes.IntegerOrNilReasonList;

import java.util.List;

public class CountExtent extends IntegerOrNilReasonList implements AbstractValue {

    public CountExtent() {
    }

    public CountExtent(List<IntegerOrNilReason> value) {
        super(value);
    }
}
