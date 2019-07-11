package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractMember;

public abstract class AbstractFeatureMember<T extends AbstractFeature> extends AbstractMember<T> {

    protected AbstractFeatureMember() {
    }

    protected AbstractFeatureMember(T object) {
        super(object);
    }
}
