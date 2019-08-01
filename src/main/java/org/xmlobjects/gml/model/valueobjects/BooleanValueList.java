package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.BooleanOrNilReason;
import org.xmlobjects.gml.model.basictypes.BooleanOrNilReasonList;

import java.util.List;

public class BooleanValueList extends BooleanOrNilReasonList implements AbstractScalarValueList {

    public BooleanValueList() {
    }

    public BooleanValueList(List<BooleanOrNilReason> value) {
        super(value);
    }
}
