package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.base.ArrayPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.LineStringSegmentArrayProperty;

import javax.xml.namespace.QName;

public class LineStringSegmentArrayPropertyBuilder extends ArrayPropertyBuilder<LineStringSegmentArrayProperty> {

    @Override
    public LineStringSegmentArrayProperty createObject(QName name) {
        return new LineStringSegmentArrayProperty();
    }
}
