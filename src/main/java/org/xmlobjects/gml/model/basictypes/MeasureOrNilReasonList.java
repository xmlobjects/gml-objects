package org.xmlobjects.gml.model.basictypes;

import java.util.List;

public class MeasureOrNilReasonList extends DoubleOrNilReasonList {
    private String uom;

    public MeasureOrNilReasonList() {
    }

    public MeasureOrNilReasonList(List<DoubleOrNilReason> value) {
        super(value);
    }

    public MeasureOrNilReasonList(List<DoubleOrNilReason> value, String uom) {
        this(value);
        this.uom = uom;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
