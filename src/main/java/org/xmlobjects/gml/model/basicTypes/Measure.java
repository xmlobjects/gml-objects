package org.xmlobjects.gml.model.basicTypes;

import org.xmlobjects.gml.model.GMLObject;

public class Measure extends GMLObject {
    private double value;
    private String uom;

    public Measure() {
    }

    public Measure(double value) {
        this.value = value;
    }

    public Measure(double value, String uom) {
        this.value = value;
        this.uom = uom;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
