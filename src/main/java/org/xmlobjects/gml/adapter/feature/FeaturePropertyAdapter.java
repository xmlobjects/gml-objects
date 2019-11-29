package org.xmlobjects.gml.adapter.feature;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.feature.FeatureProperty;

import javax.xml.namespace.QName;

public class FeaturePropertyAdapter extends AbstractFeaturePropertyAdapter<FeatureProperty<?>> {

    @Override
    public FeatureProperty<?> createObject(QName name) throws ObjectBuildException {
        return new FeatureProperty<>();
    }
}
