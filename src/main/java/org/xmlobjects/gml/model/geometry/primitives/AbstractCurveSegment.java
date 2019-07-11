package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;

public abstract class AbstractCurveSegment extends GMLObject implements CoordinateListProvider {
    private Integer numDerivativesAtStart;
    private Integer numDerivativesAtEnd;
    private Integer numDerivativeInterior;

    public Integer getNumDerivativesAtStart() {
        return numDerivativesAtStart != null ? numDerivativesAtStart : 0;
    }

    public void setNumDerivativesAtStart(Integer numDerivativesAtStart) {
        this.numDerivativesAtStart = numDerivativesAtStart;
    }

    public Integer getNumDerivativesAtEnd() {
        return numDerivativesAtEnd != null ? numDerivativesAtEnd : 0;
    }

    public void setNumDerivativesAtEnd(Integer numDerivativesAtEnd) {
        this.numDerivativesAtEnd = numDerivativesAtEnd;
    }

    public Integer getNumDerivativeInterior() {
        return numDerivativeInterior != null ? numDerivativeInterior : 0;
    }

    public void setNumDerivativeInterior(Integer numDerivativeInterior) {
        this.numDerivativeInterior = numDerivativeInterior;
    }
}
