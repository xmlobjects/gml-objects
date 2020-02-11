/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
