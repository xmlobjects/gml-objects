package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolidProperty;

import javax.xml.namespace.QName;

public class MultiSolidPropertyBuilder extends GeometryPropertyBuilder<MultiSolidProperty> {

    @Override
    public MultiSolidProperty createObject(QName name) {
        return new MultiSolidProperty();
    }
}
