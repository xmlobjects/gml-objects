package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.PointArrayProperty;

import javax.xml.namespace.QName;

public class PointArrayPropertyBuilder extends GeometryArrayPropertyBuilder<PointArrayProperty> {

    @Override
    public PointArrayProperty createObject(QName name) {
        return new PointArrayProperty();
    }
}
