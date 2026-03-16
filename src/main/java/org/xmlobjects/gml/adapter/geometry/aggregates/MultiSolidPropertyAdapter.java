/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolidProperty;

import javax.xml.namespace.QName;

public class MultiSolidPropertyAdapter extends AbstractGeometryPropertyAdapter<MultiSolidProperty> {

    @Override
    public MultiSolidProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new MultiSolidProperty();
    }
}
