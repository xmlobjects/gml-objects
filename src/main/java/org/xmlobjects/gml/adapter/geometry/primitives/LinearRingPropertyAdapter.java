package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractInlineGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.LinearRingProperty;

import javax.xml.namespace.QName;

public class LinearRingPropertyAdapter extends AbstractInlineGeometryPropertyAdapter<LinearRingProperty> {

    @Override
    public LinearRingProperty createObject(QName name) {
        return new LinearRingProperty();
    }
}
