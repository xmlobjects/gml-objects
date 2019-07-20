package org.xmlobjects.gml.builder.geometry.complexes;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplexProperty;

import javax.xml.namespace.QName;

public class GeometricComplexPropertyBuilder extends GeometryPropertyBuilder<GeometricComplexProperty> {

    @Override
    public GeometricComplexProperty createObject(QName name) {
        return new GeometricComplexProperty();
    }
}
