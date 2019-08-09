package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.AbstractAssociation;

public abstract class InlineGeometryProperty<T extends GMLObject> extends AbstractAssociation<T> {
    private T object;

    public InlineGeometryProperty() {
    }

    public InlineGeometryProperty(T object) {
        setObject(object);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = asChild(object);
    }
}
