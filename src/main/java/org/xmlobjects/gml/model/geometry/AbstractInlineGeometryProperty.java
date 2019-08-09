package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.AbstractInlineAssociation;

public abstract class AbstractInlineGeometryProperty<T extends AbstractGeometry> extends AbstractInlineAssociation<T> {

    public AbstractInlineGeometryProperty() {
    }

    public AbstractInlineGeometryProperty(T object) {
        super(object);
    }
}
