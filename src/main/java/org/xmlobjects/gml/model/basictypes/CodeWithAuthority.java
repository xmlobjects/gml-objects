package org.xmlobjects.gml.model.basictypes;

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
