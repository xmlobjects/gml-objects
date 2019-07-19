package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceArrayProperty;

import javax.xml.namespace.QName;

public class SurfaceArrayPropertyBuilder extends GeometryArrayPropertyBuilder<SurfaceArrayProperty> {

    @Override
    public SurfaceArrayProperty createObject(QName name) {
        return new SurfaceArrayProperty();
    }
}
