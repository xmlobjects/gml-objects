/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.temporal.TimePeriodProperty;

import javax.xml.namespace.QName;

public class TimePeriodPropertyAdapter extends AbstractPropertyAdapter<TimePeriodProperty> {

    @Override
    public TimePeriodProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new TimePeriodProperty();
    }
}
