package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Tin extends TriangulatedSurface {
    private List<LineStringSegmentArrayProperty> stopLines;
    private List<LineStringSegmentArrayProperty> breakLines;
    private Length maxLength;
    private GeometricPositionList controlPoints;

    public List<LineStringSegmentArrayProperty> getStopLines() {
        if (stopLines == null)
            stopLines = new ChildList<>(this);

        return stopLines;
    }

    public void setStopLines(List<LineStringSegmentArrayProperty> stopLines) {
        this.stopLines = asChild(stopLines);
    }

    public List<LineStringSegmentArrayProperty> getBreakLines() {
        if (breakLines == null)
            breakLines = new ChildList<>(this);

        return breakLines;
    }

    public void setBreakLines(List<LineStringSegmentArrayProperty> breakLines) {
        this.breakLines = asChild(breakLines);
    }

    public Length getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Length maxLength) {
        this.maxLength = asChild(maxLength);
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
        Envelope envelope = super.computeEnvelope();
        if (controlPoints != null) {
            List<Double> coordinates = controlPoints.toCoordinateList3D();
            for (int i = 0; i < coordinates.size(); i += 3)
                envelope.include(coordinates.subList(i, i + 3));
        }

        return envelope;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
