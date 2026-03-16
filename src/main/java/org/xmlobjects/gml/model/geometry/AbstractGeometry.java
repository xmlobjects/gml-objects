/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.visitor.VisitableGeometry;
import org.xmlobjects.gml.visitor.VisitableObject;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry extends AbstractGML implements SRSReference, VisitableGeometry, VisitableObject {
    private String srsName;
    private Integer srsDimension;
    private List<String> axisLabels;
    private List<String> uomLabels;

    public abstract Envelope computeEnvelope();

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
    public boolean isSetAxisLabels() {
        return axisLabels != null && !axisLabels.isEmpty();
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
    public boolean isSetUomLabels() {
        return uomLabels != null && !uomLabels.isEmpty();
    }

    @Override
    public void setUomLabels(List<String> uomLabels) {
        this.uomLabels = uomLabels;
    }
}
