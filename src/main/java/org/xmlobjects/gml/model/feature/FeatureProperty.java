package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class FeatureProperty<T extends AbstractFeature> extends AbstractProperty<T> {

    public FeatureProperty() {
    }

    public FeatureProperty(T object) {
        super(object);
    }

    public FeatureProperty(String href) {
        super(href);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractFeature.class;
    }
}
