package org.xmlobjects.gml.builder.geometry.aggregates;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;

import javax.xml.namespace.QName;

public class MultiCurvePropertyBuilder extends GeometryPropertyBuilder<MultiCurveProperty> {

    @Override
    public MultiCurveProperty createObject(QName name) {
        return new MultiCurveProperty();
    }
}
