package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Envelope extends GMLObject implements SRSReference, CoordinateListProvider {
    private DirectPosition lowerCorner;
    private DirectPosition upperCorner;
    private String srsName;
    private Integer srsDimension;
    private List<String> axisLabels;
    private List<String> uomLabels;

    public Envelope() {
    }

    public Envelope(DirectPosition lowerCorner, DirectPosition upperCorner) {
        this.lowerCorner = lowerCorner;
        this.upperCorner = upperCorner;
    }

    public DirectPosition getLowerCorner() {
        return lowerCorner;
    }

    public void setLowerCorner(DirectPosition lowerCorner) {
        this.lowerCorner = asChild(lowerCorner);
    }

    public DirectPosition getUpperCorner() {
        return upperCorner;
    }

    public void setUpperCorner(DirectPosition upperCorner) {
        this.upperCorner = asChild(upperCorner);
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
        if (srsDimension != null && srsDimension > 0)
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
        if (lowerCorner != null && upperCorner != null) {
            List<Double> coordinates = new ArrayList<>(6);
            coordinates.addAll(lowerCorner.toCoordinateList3D());
            coordinates.addAll(upperCorner.toCoordinateList3D());
            return coordinates;
        } else
            return Collections.emptyList();
    }
}
