package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class MultiCurveProperty extends GeometryProperty<MultiCurve> {

    public MultiCurveProperty() {
    }

    public MultiCurveProperty(MultiCurve multiCurve) {
        super(multiCurve);
    }

    public MultiCurveProperty(String href) {
        super(href);
    }

    @Override
    public Class<MultiCurve> getTargetType() {
        return MultiCurve.class;
    }
}
