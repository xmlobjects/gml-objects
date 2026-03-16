/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;

import javax.xml.namespace.QName;

public class SolidPropertyAdapter extends AbstractGeometryPropertyAdapter<SolidProperty> {

    @Override
    public SolidProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new SolidProperty();
    }
}
