package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.InlineGeometryProperty;

public class LinearRingProperty extends InlineGeometryProperty<LinearRing> {

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
