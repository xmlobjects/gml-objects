package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DirectPosition extends GMLObject implements SRSReference, CoordinateListProvider {
    private List<Double> value;
    private String srsName;
    private Integer srsDimension;
    private List<String> axisLabels;
    private List<String> uomLabels;

    public DirectPosition() {
    }

    public DirectPosition(List<Double> value) {
        this.value = value;
    }

    public List<Double> getValue() {
        if (value == null)
            value = new ArrayList<>();

        return value;
    }

    public void setValue(List<Double> value) {
        this.value = value;
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
        return axisLabels;
    }

    @Override
    public void setAxisLabels(List<String> axisLabels) {
        if (axisLabels == null)
            axisLabels = new ArrayList<>();

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
        Double[] coordinates = null;
        if (value != null && !value.isEmpty()) {
            coordinates = new Double[3];
            for (int i = 0; i < coordinates.length; i++)
                coordinates[i] = i < value.size() ? value.get(i) : 0d;
        }

        return coordinates != null ? Arrays.asList(coordinates) : Collections.emptyList();
    }
}
