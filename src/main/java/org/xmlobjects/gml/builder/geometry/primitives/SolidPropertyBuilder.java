package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;

import javax.xml.namespace.QName;

public class SolidPropertyBuilder extends GeometryPropertyBuilder<SolidProperty> {

    @Override
    public SolidProperty createObject(QName name) {
        return new SolidProperty();
    }
}
