package org.xmlobjects.gml.model.valueobjects;

import java.util.List;

public class ValueArray extends CompositeValue implements ReferenceSystem {
    private String codeSpace;
    private String uom;

    public ValueArray() {
    }

    public ValueArray(List<ValueProperty> valueComponent) {
        setValueComponent(valueComponent);
    }

    @Override
    public String getCodeSpace() {
        return codeSpace;
    }

    @Override
    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }

    @Override
    public String getUom() {
        return uom;
    }

    @Override
    public void setUom(String uom) {
        this.uom = uom;
    }
}
