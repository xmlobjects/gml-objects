package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;

public class MultiPointProperty extends GeometryProperty<AbstractMultiPoint> {

    public MultiPointProperty() {
    }

    public MultiPointProperty(MultiPoint multiPoint) {
        super(multiPoint);
    }

    public MultiPointProperty(SimpleMultiPoint multiPoint) {
        super(multiPoint);
    }

    public MultiPointProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractMultiPoint> getTargetType() {
        return AbstractMultiPoint.class;
    }
}
