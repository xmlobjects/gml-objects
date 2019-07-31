package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;

public class Measure extends GMLObject {
    private Double value;
    private String uom;

    public Measure() {
    }

    public Measure(Double value) {
        this.value = value;
    }

    public Measure(Double value, String uom) {
        this.value = value;
        this.uom = uom;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
