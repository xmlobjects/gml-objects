package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.common.LocalProperties;
import org.xmlobjects.gml.model.GMLObject;

public abstract class InlineProperty<T extends GMLObject> extends GMLObject implements OwnershipAttributes {
    private T object;
    private Boolean owns;
    private LocalProperties localProperties;

    protected InlineProperty() {
    }

    protected InlineProperty(T object) {
        setObject(object);
    }

    public abstract Class<T> getTargetType();

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

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }
}
