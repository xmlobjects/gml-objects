package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.AbstractInlineGeometryProperty;

public class LinearRingProperty extends AbstractInlineGeometryProperty<LinearRing> {

    public LinearRingProperty() {
    }

    public LinearRingProperty(LinearRing linearRing) {
        super(linearRing);
    }

    @Override
    public Class<LinearRing> getTargetType() {
        return LinearRing.class;
    }
}
