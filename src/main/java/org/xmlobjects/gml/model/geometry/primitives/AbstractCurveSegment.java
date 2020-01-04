package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.util.List;

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

    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        List<Double> coordinates = toCoordinateList3D();
        for (int i = 0; i < coordinates.size(); i += 3)
            envelope.include(coordinates.subList(i, i + 3));

        return envelope;
    }
}
