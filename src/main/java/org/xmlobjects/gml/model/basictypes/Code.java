package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;

public class Code extends GMLObject {
    private String value;
    private String codeSpace;

    public Code() {
    }

    public Code(String value) {
        this.value = value;
    }

    public Code(String value, String codeSpace) {
        this.value = value;
        this.codeSpace = codeSpace;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
