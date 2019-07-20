package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.gml.builder.geometry.InlineGeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.RingProperty;

import javax.xml.namespace.QName;

public class RingPropertyBuilder extends InlineGeometryPropertyBuilder<RingProperty> {

    @Override
    public RingProperty createObject(QName name) {
        return new RingProperty();
    }
}
