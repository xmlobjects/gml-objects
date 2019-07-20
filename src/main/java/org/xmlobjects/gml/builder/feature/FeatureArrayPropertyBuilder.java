package org.xmlobjects.gml.builder.feature;

import org.xmlobjects.gml.builder.base.ArrayPropertyBuilder;
import org.xmlobjects.gml.model.feature.FeatureArrayProperty;

import javax.xml.namespace.QName;

public class FeatureArrayPropertyBuilder<T extends FeatureArrayProperty> extends ArrayPropertyBuilder<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new FeatureArrayProperty<>();
    }
}
