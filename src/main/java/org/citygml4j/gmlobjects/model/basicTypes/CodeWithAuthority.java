package org.citygml4j.gmlobjects.model.basicTypes;

public class CodeWithAuthority extends Code {

    public CodeWithAuthority() {
    }

    public CodeWithAuthority(String value) {
        super(value);
    }

    public CodeWithAuthority(String value, String codeSpace) {
        this(value);
        setCodeSpace(codeSpace);
    }
}
