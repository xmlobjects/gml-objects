package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.List;

public class CodeList extends GMLObject {
    private List<String> value;
    private String codeSpace;

    public CodeList() {
    }

    public CodeList(List<String> value) {
        this.value = value;
    }

    public List<String> getValue() {
        if (value == null)
            value = new ArrayList<>();

        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
