package org.xmlobjects.gml.model.temporal;

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
}
