package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.SolidArrayProperty;

import javax.xml.namespace.QName;

public class SolidArrayPropertyBuilder extends GeometryArrayPropertyBuilder<SolidArrayProperty> {

    @Override
    public SolidArrayProperty createObject(QName name) {
        return new SolidArrayProperty();
    }
}
