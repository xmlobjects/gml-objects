/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.AbstractInlineGeometryProperty;

public class ShellProperty extends AbstractInlineGeometryProperty<Shell> {

    public ShellProperty() {
    }

    public ShellProperty(Shell shell) {
        super(shell);
    }

    @Override
    public Class<Shell> getTargetType() {
        return Shell.class;
    }
}
