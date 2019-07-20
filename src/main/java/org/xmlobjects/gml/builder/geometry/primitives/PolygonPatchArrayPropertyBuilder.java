package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.base.ArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.PolygonPatchArrayProperty;

import javax.xml.namespace.QName;

public class PolygonPatchArrayPropertyBuilder extends ArrayPropertyBuilder<PolygonPatchArrayProperty> {

    @Override
    public PolygonPatchArrayProperty createObject(QName name) {
        return new PolygonPatchArrayProperty();
    }
}
