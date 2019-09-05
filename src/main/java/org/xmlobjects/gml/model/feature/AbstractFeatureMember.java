package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public abstract class AbstractFeatureMember<T extends AbstractFeature> extends AbstractInlineProperty<T> {

    public AbstractFeatureMember() {
    }

    public AbstractFeatureMember(T object) {
        super(object);
    }
}
