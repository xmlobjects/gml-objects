package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.ArrayList;
import java.util.List;

public class CodeOrNilReasonList extends GMLObject {
    private List<NameOrNilReason> value;
    private String codeSpace;

    public CodeOrNilReasonList() {
    }

    public CodeOrNilReasonList(List<NameOrNilReason> value) {
        setValue(value);
    }

    public List<NameOrNilReason> getValue() {
        if (value == null)
            value = new ChildList<>(this);

        return value;
    }

    public void setValue(List<NameOrNilReason> value) {
        this.value = asChild(value);
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
