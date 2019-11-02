package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.GenericElement;

public abstract class AbstractMetadataProperty<T extends GMLObject> extends AbstractAssociation<T> implements OwnershipAttributes {
    private T object;
    private GenericElement genericElement;
    private Boolean owns;

    public AbstractMetadataProperty() {
    }

    public AbstractMetadataProperty(T object) {
        setObject(object);
    }

    public AbstractMetadataProperty(GenericElement element) {
        setGenericElement(element);
    }

    public T getObject() {
        return object;
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    public void setObject(T object) {
        this.object = asChild(object);
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

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }
}
