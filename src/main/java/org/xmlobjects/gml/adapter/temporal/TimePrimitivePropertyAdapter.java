/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.temporal.TimePrimitiveProperty;

import javax.xml.namespace.QName;

public class TimePrimitivePropertyAdapter extends AbstractTimePrimitivePropertyAdapter<TimePrimitiveProperty<?>> {

    @Override
    public TimePrimitiveProperty<?> createObject(QName name, Object parent) throws ObjectBuildException {
        return new TimePrimitiveProperty<>();
    }
}
