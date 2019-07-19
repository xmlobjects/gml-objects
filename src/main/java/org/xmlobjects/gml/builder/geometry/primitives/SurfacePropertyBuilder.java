package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import javax.xml.namespace.QName;

public class SurfacePropertyBuilder extends GeometryPropertyBuilder<SurfaceProperty> {

    @Override
    public SurfaceProperty createObject(QName name) {
        return new SurfaceProperty();
    }
}
