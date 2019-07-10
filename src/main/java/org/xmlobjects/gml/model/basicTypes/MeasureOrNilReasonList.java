package org.xmlobjects.gml.model.basicTypes;

import java.util.List;

public class MeasureOrNilReasonList {
    private List<DoubleOrNilReason> value;
    private String uom;

    public MeasureOrNilReasonList() {
    }

    public MeasureOrNilReasonList(List<DoubleOrNilReason> value) {
        this.value = value;
    }

    public MeasureOrNilReasonList(List<DoubleOrNilReason> value, String uom) {
        this.value = value;
        this.uom = uom;
    }

    public List<DoubleOrNilReason> getValue() {
        return value;
    }

    public void setValue(List<DoubleOrNilReason> value) {
        this.value = value;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
