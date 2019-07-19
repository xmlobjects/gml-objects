package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;

import javax.xml.namespace.QName;

public class CurvePropertyBuilder extends GeometryPropertyBuilder<CurveProperty> {

    @Override
    public CurveProperty createObject(QName name) {
        return new CurveProperty();
    }
}
