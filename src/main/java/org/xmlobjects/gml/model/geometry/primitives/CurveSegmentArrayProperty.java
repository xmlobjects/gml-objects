package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.base.AbstractArrayProperty;

import java.util.List;

public class CurveSegmentArrayProperty extends AbstractArrayProperty<AbstractCurveSegment> {

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
