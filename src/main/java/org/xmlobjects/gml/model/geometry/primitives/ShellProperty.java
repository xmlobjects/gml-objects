package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.InlineGeometryProperty;

public class ShellProperty extends InlineGeometryProperty<Shell> {

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
