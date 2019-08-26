package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractProperty;
import org.xmlobjects.gml.model.common.GenericElement;

public class FeatureProperty<T extends AbstractFeature> extends AbstractProperty<T> {
    private GenericElement genericElement;

    public FeatureProperty() {
    }

    public FeatureProperty(T object) {
        super(object);
    }

    public FeatureProperty(String href) {
        super(href);
    }

    public FeatureProperty(GenericElement element) {
        setGenericElement(element);
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

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractFeature.class;
    }
}
