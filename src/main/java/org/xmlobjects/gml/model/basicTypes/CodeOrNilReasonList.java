package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;

import java.util.List;

public class CodeOrNilReasonList extends GMLObject {
    private List<NameOrNilReason> value;
    private String codeSpace;

    public CodeOrNilReasonList() {
    }

    public CodeOrNilReasonList(List<NameOrNilReason> value) {
        this.value = value;
    }

    public List<NameOrNilReason> getValue() {
        return value;
    }

    public void setValue(List<NameOrNilReason> value) {
        this.value = value;
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
