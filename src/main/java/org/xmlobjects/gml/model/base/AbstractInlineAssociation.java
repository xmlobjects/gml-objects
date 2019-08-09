package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;

public abstract class AbstractInlineAssociation<T extends GMLObject> extends AbstractAssociation<T> {
    private T object;

    public AbstractInlineAssociation() {
    }

    public AbstractInlineAssociation(T object) {
        setObject(object);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = asChild(object);
    }
}
