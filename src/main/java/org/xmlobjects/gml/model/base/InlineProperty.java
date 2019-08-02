package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;

public abstract class InlineProperty<T extends GMLObject> extends Association<T> implements OwnershipAttributes {
    private T object;
    private Boolean owns;

    public InlineProperty() {
    }

    public InlineProperty(T object) {
        setObject(object);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = asChild(object);
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
