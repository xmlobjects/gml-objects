package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.visitor.ObjectVisitor;

public class TimePeriod extends AbstractTimeGeometricPrimitive {
    private TimePosition beginPosition;
    private TimeInstantProperty begin;
    private TimePosition endPosition;
    private TimeInstantProperty end;
    private TimeDuration duration;
    private TimeIntervalLength timeInterval;

    public TimePeriod() {
    }

    public TimePeriod(TimePosition beginPosition, TimePosition endPosition) {
        setBeginPosition(beginPosition);
        setEndPosition(endPosition);
    }

    public TimePeriod(TimeInstantProperty begin, TimeInstantProperty end) {
        setBegin(begin);
        setEnd(end);
    }

    public TimePosition getBeginPosition() {
        return beginPosition;
    }

    public boolean isSetBeginPosition() {
        return beginPosition != null;
    }

    public void setBeginPosition(TimePosition beginPosition) {
        this.beginPosition = asChild(beginPosition);
        begin = null;
    }

    public TimeInstantProperty getBegin() {
        return begin;
    }

    public boolean isSetBegin() {
        return begin != null;
    }

    public void setBegin(TimeInstantProperty begin) {
        this.begin = asChild(begin);
        beginPosition = null;
    }

    public TimePosition getEndPosition() {
        return endPosition;
    }

    public boolean isSetEndPosition() {
        return endPosition != null;
    }

    public void setEndPosition(TimePosition endPosition) {
        this.endPosition = asChild(endPosition);
        end = null;
    }

    public TimeInstantProperty getEnd() {
        return end;
    }

    public boolean isSetEnd() {
        return end != null;
    }

    public void setEnd(TimeInstantProperty end) {
        this.end = asChild(end);
        endPosition = null;
    }

    public TimeDuration getDuration() {
        return duration;
    }

    public boolean isSetDuration() {
        return duration != null;
    }

    public void setDuration(TimeDuration duration) {
        this.duration = asChild(duration);
        timeInterval = null;
    }

    public TimeIntervalLength getTimeInterval() {
        return timeInterval;
    }

    public boolean isSetTimeInterval() {
        return timeInterval != null;
    }

    public void setTimeInterval(TimeIntervalLength timeInterval) {
        this.timeInterval = asChild(timeInterval);
        duration = null;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
