package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.common.GenericElement;

import java.util.List;

public class FeatureArrayProperty<T extends AbstractFeature> extends AbstractArrayProperty<T> {
    private List<GenericElement> genericElements;

    public FeatureArrayProperty() {
    }

    public FeatureArrayProperty(List<T> objects) {
        super(objects);
    }

    public boolean isSetObject() {
        return !getObjects().isEmpty();
    }

    public List<GenericElement> getGenericElements() {
        if (genericElements == null)
            genericElements = new ChildList<>(this);

        return genericElements;
    }

    public boolean isSetGenericElements() {
        return genericElements != null && !genericElements.isEmpty();
    }

    public void setGenericElements(List<GenericElement> genericElements) {
        this.genericElements = asChild(genericElements);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractFeature.class;
    }
}
