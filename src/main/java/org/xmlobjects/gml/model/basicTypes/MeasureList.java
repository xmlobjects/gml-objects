package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.List;

public class MeasureList extends GMLObject {
    private List<Double> value;
    private String uom;

    public MeasureList() {
    }

    public MeasureList(List<Double> value) {
        if (value == null)
            value = new ArrayList<>();

        this.value = value;
    }

    public MeasureList(List<Double> value, String uom) {
        this.value = value;
        this.uom = uom;
    }

    public List<Double> getValue() {
        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
