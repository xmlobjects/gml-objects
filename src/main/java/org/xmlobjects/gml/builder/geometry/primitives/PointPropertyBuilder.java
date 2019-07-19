package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import javax.xml.namespace.QName;

public class PointPropertyBuilder extends GeometryPropertyBuilder<PointProperty> {

    @Override
    public PointProperty createObject(QName name) {
        return new PointProperty();
    }
}
