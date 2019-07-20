package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometryProperty;

import javax.xml.namespace.QName;

public class MultiGeometryPropertyBuilder extends GeometryPropertyBuilder<MultiGeometryProperty> {

    @Override
    public MultiGeometryProperty createObject(QName name) {
        return new MultiGeometryProperty();
    }
}
