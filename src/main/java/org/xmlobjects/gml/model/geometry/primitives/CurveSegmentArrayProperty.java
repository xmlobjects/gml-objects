package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.ArrayProperty;

import java.util.List;

public class CurveSegmentArrayProperty extends ArrayProperty<AbstractCurveSegment> {

    public CurveSegmentArrayProperty() {
    }

    public CurveSegmentArrayProperty(List<AbstractCurveSegment> objects) {
        super(objects);
    }

    @Override
    public Class<AbstractCurveSegment> getTargetType() {
        return AbstractCurveSegment.class;
    }
}
