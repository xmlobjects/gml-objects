package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.util.GMLPatterns;

public class TimeIntervalLength extends GMLObject {
    private Double value;
    private String unit;
    private Integer radix;
    private Integer factor;

    public TimeIntervalLength() {
    }

    public TimeIntervalLength(Double value, TimeUnit unit) {
        this.value = value;
        setUnit(unit);
    }

    public TimeIntervalLength(Double value, String unit) {
        this.value = value;
        setUnit(unit);
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit.toValue();
    }

    public void setUnit(String unit) {
        if (TimeUnit.fromValue(unit) != null || GMLPatterns.OTHER_VALUE.matcher(unit).matches())
            this.unit = unit;
    }

    public Integer getRadix() {
        return radix;
    }

    public void setRadix(Integer radix) {
        if (radix == null || radix >= 0)
            this.radix = radix;
    }

    public Integer getFactor() {
        return factor;
    }

    public void setFactor(Integer factor) {
        this.factor = factor;
    }
}
