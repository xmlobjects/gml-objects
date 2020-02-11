/*
 * gml-objects - A Java XML binding for the OGC Geography Markup Language (GML)
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

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectPositionList extends GMLObject implements SRSReference, CoordinateListProvider {
    private List<Double> value;
    private Integer count;
    private String srsName;
    private Integer srsDimension;
    private List<String> axisLabels;
    private List<String> uomLabels;

    public DirectPositionList() {
    }

    public DirectPositionList(List<Double> value) {
        this.value = value;
    }

    public DirectPositionList(double... ordinates) {
        if (ordinates != null && ordinates.length > 0) {
            value = new ArrayList<>(ordinates.length);
            for (double ordinate : ordinates)
                value.add(ordinate);
        }
    }

    public List<Double> getValue() {
        if (value == null)
            value = new ArrayList<>();

        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        if (count == null || count > 0)
            this.count = count;
    }

    @Override
    public String getSrsName() {
        return srsName;
    }

    @Override
    public void setSrsName(String srsName) {
        this.srsName = srsName;
    }

    @Override
    public Integer getSrsDimension() {
        return srsDimension;
    }

    @Override
    public void setSrsDimension(Integer srsDimension) {
        if (srsDimension == null || srsDimension > 0)
            this.srsDimension = srsDimension;
    }

    @Override
    public List<String> getAxisLabels() {
        if (axisLabels == null)
            axisLabels = new ArrayList<>();

        return axisLabels;
    }

    @Override
    public void setAxisLabels(List<String> axisLabels) {
        this.axisLabels = axisLabels;
    }

    @Override
    public List<String> getUomLabels() {
        if (uomLabels == null)
            uomLabels = new ArrayList<>();

        return uomLabels;
    }

    @Override
    public void setUomLabels(List<String> uomLabels) {
        this.uomLabels = uomLabels;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        List<Double> coordinates = null;
        if (value != null && !value.isEmpty()) {
            int dim = 3;

            if (srsDimension != null)
                dim = srsDimension;
            else if (count != null)
                dim = value.size() / count;
            else {
                SRSReference srsReference = getInheritedSRSReference();
                if (srsReference.getSrsDimension() != null)
                    dim = srsReference.getSrsDimension();
            }

            int count = value.size() / dim;
            if (value.size() > count * dim)
                count++;

            coordinates = new ArrayList<>(count * 3);
            for (int i = 0; i < value.size(); i += dim) {
                coordinates.add(value.get(i));
                coordinates.add(dim > 1 && i + 1 < value.size() ? value.get(i + 1) : 0d);
                coordinates.add(dim > 2 && i + 2 < value.size() ? value.get(i + 2) : 0d);
            }
        }

        return coordinates != null ? coordinates : Collections.emptyList();
    }
}
