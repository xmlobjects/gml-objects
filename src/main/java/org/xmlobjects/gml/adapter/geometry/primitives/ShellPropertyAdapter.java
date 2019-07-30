package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.InlineGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;

import javax.xml.namespace.QName;

public class ShellPropertyAdapter extends InlineGeometryPropertyAdapter<ShellProperty> {

    @Override
    public ShellProperty createObject(QName name) {
        return new ShellProperty();
    }
}