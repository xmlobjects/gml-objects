package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractInlineGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.ShellProperty;

import javax.xml.namespace.QName;

public class ShellPropertyAdapter extends AbstractInlineGeometryPropertyAdapter<ShellProperty> {

    @Override
    public ShellProperty createObject(QName name) {
        return new ShellProperty();
    }
}
