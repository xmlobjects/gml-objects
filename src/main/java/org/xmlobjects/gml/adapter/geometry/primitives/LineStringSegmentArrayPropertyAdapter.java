package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.ArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.LineStringSegmentArrayProperty;

import javax.xml.namespace.QName;

public class LineStringSegmentArrayPropertyAdapter extends ArrayPropertyAdapter<LineStringSegmentArrayProperty> {

    @Override
    public LineStringSegmentArrayProperty createObject(QName name) {
        return new LineStringSegmentArrayProperty();
    }
}
