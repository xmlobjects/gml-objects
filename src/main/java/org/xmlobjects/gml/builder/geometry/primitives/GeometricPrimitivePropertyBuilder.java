package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;

import javax.xml.namespace.QName;

public class GeometricPrimitivePropertyBuilder extends GeometryPropertyBuilder<GeometricPrimitiveProperty> {

    @Override
    public GeometricPrimitiveProperty createObject(QName name) {
        return new GeometricPrimitiveProperty();
    }
}
