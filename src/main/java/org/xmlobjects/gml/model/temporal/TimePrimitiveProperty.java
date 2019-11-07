package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class TimePrimitiveProperty<T extends AbstractTimePrimitive> extends AbstractProperty<T> {

    public TimePrimitiveProperty() {
    }

    public TimePrimitiveProperty(T object) {
        super(object);
    }

    public TimePrimitiveProperty(String href) {
        super(href);
    }

    @Override
    public T getObject() {
        return super.getObject();
    }

    @Override
    public void setObject(T object) {
        super.setObject(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractTimePrimitive.class;
    }
}
