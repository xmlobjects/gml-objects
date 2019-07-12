package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;

import java.util.List;

public class Tin extends TriangulatedSurface {
    private List<LineStringSegmentArrayProperty> stopLines;
    private List<LineStringSegmentArrayProperty> breakLines;
    private List<LineStringSegmentArrayProperty> maxLength;
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

    public List<LineStringSegmentArrayProperty> getMaxLength() {
        if (maxLength == null)
            maxLength = new ChildList<>(this);

        return maxLength;
    }

    public void setMaxLength(List<LineStringSegmentArrayProperty> maxLength) {
        this.maxLength = asChild(maxLength);
    }

    public GeometricPositionList getControlPoints() {
        return controlPoints;
    }

    public void setControlPoints(GeometricPositionList controlPoints) {
        this.controlPoints = asChild(controlPoints);
    }
}
