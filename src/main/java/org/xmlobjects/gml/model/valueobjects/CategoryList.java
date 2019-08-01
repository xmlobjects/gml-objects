package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.basictypes.CodeOrNilReasonList;
import org.xmlobjects.gml.model.basictypes.NameOrNilReason;

import java.util.List;

public class CategoryList extends CodeOrNilReasonList implements AbstractScalarValueList {

    public CategoryList() {
    }

    public CategoryList(List<NameOrNilReason> value) {
        super(value);
    }

    public CategoryList(List<NameOrNilReason> value, String codeSpace) {
        super(value, codeSpace);
    }
}
