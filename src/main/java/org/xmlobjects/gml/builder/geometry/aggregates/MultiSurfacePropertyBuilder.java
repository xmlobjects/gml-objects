package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

import javax.xml.namespace.QName;

public class MultiSurfacePropertyBuilder extends GeometryPropertyBuilder<MultiSurfaceProperty> {

    @Override
    public MultiSurfaceProperty createObject(QName name) {
        return new MultiSurfaceProperty();
    }
}
