package org.xmlobjects.gml.builder.feature;

import org.xmlobjects.gml.builder.base.AbstractPropertyBuilder;
import org.xmlobjects.gml.model.feature.FeatureProperty;

import javax.xml.namespace.QName;

public class FeaturePropertyBuilder<T extends FeatureProperty> extends AbstractPropertyBuilder<T> {

    @SuppressWarnings("unchecked")
    @Override
    public T createObject(QName name) {
        return (T) new FeatureProperty<>();
    }
}
