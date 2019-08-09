package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.AbstractInlineGeometryProperty;

public class RingProperty extends AbstractInlineGeometryProperty<Ring> {

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
