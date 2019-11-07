package org.xmlobjects.gml.model.temporal;

public class RelatedTime<T extends AbstractTimePrimitive> extends TimePrimitiveProperty<T> {
    private RelativePosition relativePosition;

    public RelatedTime() {
    }

    public RelatedTime(T object) {
        super(object);
    }

    public RelatedTime(String href) {
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

    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    public void setRelativePosition(RelativePosition relativePosition) {
        this.relativePosition = relativePosition;
    }
}
