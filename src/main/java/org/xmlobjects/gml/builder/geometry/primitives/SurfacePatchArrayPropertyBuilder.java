package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.base.ArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.SurfacePatchArrayProperty;

import javax.xml.namespace.QName;

public class SurfacePatchArrayPropertyBuilder extends ArrayPropertyBuilder<SurfacePatchArrayProperty> {

    @Override
    public SurfacePatchArrayProperty createObject(QName name) {
        return new SurfacePatchArrayProperty();
    }
}
