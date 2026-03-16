/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractInlineGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;

import javax.xml.namespace.QName;

public class ShellPropertyAdapter extends AbstractInlineGeometryPropertyAdapter<ShellProperty> {

    @Override
    public ShellProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new ShellProperty();
    }
}
