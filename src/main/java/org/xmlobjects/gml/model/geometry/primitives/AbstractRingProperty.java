package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.AbstractInlineGeometryProperty;

public class AbstractRingProperty extends AbstractInlineGeometryProperty<AbstractRing> {

    public AbstractRingProperty() {
    }

    public AbstractRingProperty(AbstractRing ring) {
        super(ring);
    }

    @Override
    public Class<AbstractRing> getTargetType() {
        return AbstractRing.class;
    }
}
