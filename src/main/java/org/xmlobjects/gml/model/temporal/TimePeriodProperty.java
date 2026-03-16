/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.base.AbstractProperty;

public class TimePeriodProperty extends AbstractProperty<TimePeriod> {

    public TimePeriodProperty() {
    }

    public TimePeriodProperty(TimePeriod object) {
        super(object);
    }

    public TimePeriodProperty(String href) {
        super(href);
    }

    @Override
    public Class<TimePeriod> getTargetType() {
        return TimePeriod.class;
    }
}
