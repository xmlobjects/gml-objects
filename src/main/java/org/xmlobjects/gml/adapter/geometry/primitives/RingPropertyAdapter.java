package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.InlineGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.RingProperty;

import javax.xml.namespace.QName;

public class RingPropertyAdapter extends InlineGeometryPropertyAdapter<RingProperty> {

    @Override
    public RingProperty createObject(QName name) {
        return new RingProperty();
    }
}
