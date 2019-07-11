package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.ArrayProperty;

import java.util.List;

public class FeatureArrayProperty<T extends AbstractFeature> extends ArrayProperty<T> {

    public FeatureArrayProperty() {
    }

    public FeatureArrayProperty(List<T> objects) {
        super(objects);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractFeature.class;
    }
}
