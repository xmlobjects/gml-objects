package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.base.Association;

public abstract class InlineGeometryProperty<T extends GMLObject> extends Association<T> {
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
