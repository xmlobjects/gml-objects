package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class MeasureOrNilReasonList extends GMLObject {
    private List<DoubleOrNilReason> value;
    private String uom;

    public MeasureOrNilReasonList() {
    }

    public MeasureOrNilReasonList(List<DoubleOrNilReason> value) {
        setValue(value);
    }

    public MeasureOrNilReasonList(List<DoubleOrNilReason> value, String uom) {
        this(value);
        this.uom = uom;
    }

    public List<DoubleOrNilReason> getValue() {
        if (value == null)
            value = new ChildList<>(this);

        return value;
    }

    public void setValue(List<DoubleOrNilReason> value) {
        this.value = asChild(value);
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
