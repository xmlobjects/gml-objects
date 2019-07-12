package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.ArrayProperty;

import java.util.List;

public class LineStringSegmentArrayProperty extends ArrayProperty<LineStringSegment> {

    public LineStringSegmentArrayProperty() {
    }

    public LineStringSegmentArrayProperty(List<LineStringSegment> objects) {
        super(objects);
    }

    @Override
    public Class<LineStringSegment> getTargetType() {
        return LineStringSegment.class;
    }
}
