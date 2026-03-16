/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class TimeInstantProperty extends AbstractProperty<TimeInstant> {

    public TimeInstantProperty() {
    }

    public TimeInstantProperty(TimeInstant object) {
        super(object);
    }

    public TimeInstantProperty(String href) {
        super(href);
    }

    @Override
    public Class<TimeInstant> getTargetType() {
        return TimeInstant.class;
    }
}
