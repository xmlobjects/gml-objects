package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractInlineProperty;
import org.xmlobjects.gml.model.common.GenericElement;

public abstract class AbstractFeatureMember<T extends AbstractFeature> extends AbstractInlineProperty<T> {
    private GenericElement genericElement;

    public AbstractFeatureMember() {
    }

    public AbstractFeatureMember(T object) {
        super(object);
    }

    public AbstractFeatureMember(GenericElement element) {
        setGenericElement(element);
    }

    @Override
    public T getObject() {
        return super.getObject();
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    @Override
    public void setObject(T object) {
        super.setObject(object);
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
