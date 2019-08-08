package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.InlineGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.LinearRingProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class LinearRingPropertyAdapter extends InlineGeometryPropertyAdapter<LinearRingProperty> {

    @Override
    public LinearRingProperty createObject(QName name) {
        return new LinearRingProperty();
    }
}
