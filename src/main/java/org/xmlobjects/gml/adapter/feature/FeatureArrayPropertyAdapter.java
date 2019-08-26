package org.xmlobjects.gml.adapter.feature;

import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.feature.FeatureArrayProperty;

import javax.xml.namespace.QName;

public class FeatureArrayPropertyAdapter extends AbstractFeatureArrayPropertyAdapter<FeatureArrayProperty<AbstractFeature>> {

    @Override
    public FeatureArrayProperty<AbstractFeature> createObject(QName name) {
        return new FeatureArrayProperty<>();
    }
}
