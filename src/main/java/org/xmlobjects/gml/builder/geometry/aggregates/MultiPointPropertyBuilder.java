package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;

import javax.xml.namespace.QName;

public class MultiPointPropertyBuilder extends GeometryPropertyBuilder<MultiPointProperty> {

    @Override
    public MultiPointProperty createObject(QName name) {
        return new MultiPointProperty();
    }
}
