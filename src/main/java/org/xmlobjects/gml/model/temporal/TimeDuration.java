/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.CopyContext;
import org.xmlobjects.util.copy.Copyable;
import org.xmlobjects.xml.TextContent;

import javax.xml.datatype.Duration;

public class TimeDuration extends GMLObject implements Copyable {
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
    public Copyable deepCopy(CopyBuilder builder, CopyContext context) {
        return new TimeDuration(value);
    }
}
