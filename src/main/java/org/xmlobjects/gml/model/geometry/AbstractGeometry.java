package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.visitor.GeometryVisitor;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry extends AbstractGML implements SRSReference {
    private String srsName;
    private Integer srsDimension;
    private List<String> axisLabels;
    private List<String> uomLabels;

    public abstract void accept(GeometryVisitor visitor);

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
    public SRSReference getInheritedSRSReference() {
        if (srsName == null) {
            GMLObject parent = this;

            while ((parent = parent.getParent()) != null) {
                if (parent instanceof AbstractGeometry)
                    return ((AbstractGeometry) parent).getInheritedSRSReference();
                else if (parent instanceof AbstractFeature) {
                    AbstractFeature feature = (AbstractFeature) parent;
                    if (feature.getBoundedBy() != null
                            && feature.getBoundedBy().getEnvelope() != null
                            && feature.getBoundedBy().getEnvelope().getSrsName() != null)
                        return feature.getBoundedBy().getEnvelope();
                }
            }
        }

        return this;
    }
}
