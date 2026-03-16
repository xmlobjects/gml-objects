/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

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
    public void setInlineObject(T object) {
        super.setInlineObject(object);
    }

    @Override
    public void setReferencedObject(T object) {
        super.setReferencedObject(object);
    }

    public RelativePosition getRelativePosition() {
        return relativePosition;
    }

    public void setRelativePosition(RelativePosition relativePosition) {
        this.relativePosition = relativePosition;
    }
}
