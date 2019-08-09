package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;

public abstract class AbstractInlineProperty<T extends GMLObject> extends AbstractInlineAssociation<T> implements OwnershipAttributes {
    private Boolean owns;

    public AbstractInlineProperty() {
    }

    public AbstractInlineProperty(T object) {
        super(object);
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
