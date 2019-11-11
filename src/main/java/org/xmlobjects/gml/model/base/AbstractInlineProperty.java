package org.xmlobjects.gml.model.base;

import org.xmlobjects.model.Child;

public abstract class AbstractInlineProperty<T extends Child> extends AbstractAssociation<T> {
    private T object;

    public AbstractInlineProperty() {
    }

    public AbstractInlineProperty(T object) {
        setObject(object);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = asChild(object);
    }
}
