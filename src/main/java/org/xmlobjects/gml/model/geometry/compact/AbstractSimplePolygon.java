package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;

import java.util.List;

public abstract class AbstractSimplePolygon extends AbstractSurface {
    private GeometricPositionList controlPoints;

    public AbstractSimplePolygon() {
    }

    public AbstractSimplePolygon(GeometricPositionList controlPoints) {
        setControlPoints(controlPoints);
    }

    public AbstractSimplePolygon(DirectPositionList posList) {
        this(new GeometricPositionList(posList));
    }

    public GeometricPositionList getControlPoints() {
        if (controlPoints == null)
            controlPoints = asChild(new GeometricPositionList());

        return controlPoints;
    }

    public void setControlPoints(GeometricPositionList controlPoints) {
        this.controlPoints = asChild(controlPoints);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (controlPoints != null) {
            List<Double> coordinates = controlPoints.toCoordinateList3D();
            for (int i = 0; i < coordinates.size(); i += 3)
                envelope.include(coordinates.subList(i, i + 3));
        }

        return envelope;
    }
}
