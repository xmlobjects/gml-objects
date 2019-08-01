package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.CodeOrNilReasonList;
import org.xmlobjects.gml.model.basictypes.NameOrNilReason;

import java.util.List;

public class CategoryExtent extends CodeOrNilReasonList implements AbstractValue {

    public CategoryExtent() {
    }

    public CategoryExtent(List<NameOrNilReason> value) {
        super(value);
    }

    public CategoryExtent(List<NameOrNilReason> value, String codeSpace) {
        super(value, codeSpace);
    }
}
