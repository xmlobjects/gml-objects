package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.xml.TextContent;

import javax.xml.datatype.Duration;

public class TimeDuration extends GMLObject {
    private Duration value;

    public TimeDuration() {
    }

    public TimeDuration(Duration value) {
        this.value = value;
    }

    public TimeDuration(String value) {
        setValue(value);
    }

    public Duration getValue() {
        return value;
    }

    public void setValue(Duration value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = TextContent.of(value).getAsDuration();
    }

    @Override
    public TimeDuration shallowCopy(CopyBuilder builder) {
        return new TimeDuration(value);
    }

    @Override
    public TimeDuration deepCopy(CopyBuilder builder) {
        return new TimeDuration(value);
    }
}
