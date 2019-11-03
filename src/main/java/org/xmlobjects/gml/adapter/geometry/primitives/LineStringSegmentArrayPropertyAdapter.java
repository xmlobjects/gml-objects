package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.LineStringSegmentArrayProperty;

import javax.xml.namespace.QName;

public class LineStringSegmentArrayPropertyAdapter extends AbstractArrayPropertyAdapter<LineStringSegmentArrayProperty> {

    @Override
    public LineStringSegmentArrayProperty createObject(QName name) throws ObjectBuildException {
        return new LineStringSegmentArrayProperty();
    }
}
