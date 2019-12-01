package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.visitor.ObjectVisitor;

public class TimeInstant extends AbstractTimeGeometricPrimitive {
    private TimePosition timePosition;

    public TimeInstant() {
    }

    public TimeInstant(TimePosition timePosition) {
        setTimePosition(timePosition);
    }

    public TimePosition getTimePosition() {
        return timePosition;
    }

    public void setTimePosition(TimePosition timePosition) {
        this.timePosition = asChild(timePosition);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
