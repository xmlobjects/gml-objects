package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.InlineGeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;

import javax.xml.namespace.QName;

public class ShellPropertyBuilder extends InlineGeometryPropertyBuilder<ShellProperty> {

    @Override
    public ShellProperty createObject(QName name) {
        return new ShellProperty();
    }
}
