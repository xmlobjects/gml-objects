package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractMember;
import org.xmlobjects.gml.model.common.GenericElement;

public abstract class AbstractFeatureMember<T extends AbstractFeature> extends AbstractMember<T> {
    private GenericElement genericElement;

    public AbstractFeatureMember() {
    }

    public AbstractFeatureMember(T object) {
        super(object);
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    public GenericElement getGenericElement() {
        return genericElement;
    }

    public boolean isSetGenericElement() {
        return genericElement != null;
    }

    public void setGenericElement(GenericElement genericElement) {
        this.genericElement = asChild(genericElement);
    }
}
