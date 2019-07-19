package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.GeometryArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.CurveArrayProperty;

import javax.xml.namespace.QName;

public class CurveArrayPropertyBuilder extends GeometryArrayPropertyBuilder<CurveArrayProperty> {

    @Override
    public CurveArrayProperty createObject(QName name) {
        return new CurveArrayProperty();
    }
}
