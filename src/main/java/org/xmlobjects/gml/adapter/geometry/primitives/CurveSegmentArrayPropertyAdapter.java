package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.ArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.CurveSegmentArrayProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class CurveSegmentArrayPropertyAdapter extends ArrayPropertyAdapter<CurveSegmentArrayProperty> {

    @Override
    public CurveSegmentArrayProperty createObject(QName name) {
        return new CurveSegmentArrayProperty();
    }
}
