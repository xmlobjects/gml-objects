/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;

import javax.xml.namespace.QName;

public class GeometryArrayPropertyAdapter extends AbstractGeometryArrayPropertyAdapter<GeometryArrayProperty<?>> {

    @Override
    public GeometryArrayProperty<AbstractGeometry> createObject(QName name, Object parent) throws ObjectBuildException {
        return new GeometryArrayProperty<>();
    }
}
