package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.InlineGeometryProperty;

public class AbstractRingProperty extends InlineGeometryProperty<AbstractRing> {

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
