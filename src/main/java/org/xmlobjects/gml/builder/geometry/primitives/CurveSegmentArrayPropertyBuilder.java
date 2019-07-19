package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.ArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.CurveSegmentArrayProperty;

import javax.xml.namespace.QName;

public class CurveSegmentArrayPropertyBuilder extends ArrayPropertyBuilder<CurveSegmentArrayProperty> {

    @Override
    public CurveSegmentArrayProperty createObject(QName name) {
        return new CurveSegmentArrayProperty();
    }
}
