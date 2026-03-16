/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

import javax.xml.namespace.QName;

public class GeometryPropertyAdapter extends AbstractGeometryPropertyAdapter<GeometryProperty<?>> {

    @Override
    public GeometryProperty<?> createObject(QName name, Object parent) throws ObjectBuildException {
        return new GeometryProperty<>();
    }
}
