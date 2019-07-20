package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.base.ArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.TriangleArrayProperty;

import javax.xml.namespace.QName;

public class TriangleArrayPropertyBuilder extends ArrayPropertyBuilder<TriangleArrayProperty> {

    @Override
    public TriangleArrayProperty createObject(QName name) {
        return new TriangleArrayProperty();
    }
}
