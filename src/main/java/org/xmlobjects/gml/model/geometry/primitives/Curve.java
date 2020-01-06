package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curve extends AbstractCurve {
    private CurveSegmentArrayProperty segments;

    public Curve() {
    }

    public Curve(CurveSegmentArrayProperty segments) {
        setSegments(segments);
    }

    public CurveSegmentArrayProperty getSegments() {
        return segments;
    }

    public void setSegments(CurveSegmentArrayProperty segments) {
        this.segments = asChild(segments);
    }

    @Override
    public List<Double> toCoordinateList3D() {
        if (segments != null) {
            List<Double> coordinates = new ArrayList<>();
            for (AbstractCurveSegment segment : segments.getObjects()) {
                if (segment != null) {
                    List<Double> candidates = segment.toCoordinateList3D();
                    if (!candidates.isEmpty()) {
                        int size = coordinates.size();
                        if (size == 0)
                            coordinates.addAll(candidates);
                        else {
                            if (candidates.get(0).doubleValue() == coordinates.get(size - 3).doubleValue()
                                    && candidates.get(1).doubleValue() == coordinates.get(size - 2).doubleValue()
                                    && candidates.get(2).doubleValue() == coordinates.get(size - 1).doubleValue())
                                coordinates.addAll(candidates.subList(3, candidates.size()));
                            else
                                coordinates.addAll(candidates);
                        }
                    }
                }
            }

            return coordinates;
        } else
            return Collections.emptyList();
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
