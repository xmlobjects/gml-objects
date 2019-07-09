package org.citygml4j.gmlobjects.model.basicTypes;

import org.citygml4j.gmlobjects.model.common.ModelObject;

public class Code extends ModelObject {
    private String value;
    private String codeSpace;

    public Code() {
    }

    public Code(String value) {
        this.value = value;
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
