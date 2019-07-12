package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.InlineGeometryProperty;

public class RingProperty extends InlineGeometryProperty<Ring> {

    public RingProperty() {
    }

    public RingProperty(Ring ring) {
        super(ring);
    }

    @Override
    public Class<Ring> getTargetType() {
        return Ring.class;
    }
}
