package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class MultiPointProperty extends GeometryProperty<MultiPoint> {

    public MultiPointProperty() {
    }

    public MultiPointProperty(MultiPoint multiPoint) {
        super(multiPoint);
    }

    public MultiPointProperty(String href) {
        super(href);
    }

    @Override
    public Class<MultiPoint> getTargetType() {
        return MultiPoint.class;
    }
}
