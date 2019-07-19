package org.xmlobjects.gml.builder.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.builder.geometry.InlineGeometryPropertyBuilder;
import org.xmlobjects.gml.model.geometry.primitives.LinearRingProperty;

import javax.xml.namespace.QName;

public class LinearRingPropertyBuilder extends InlineGeometryPropertyBuilder<LinearRingProperty> {

    @Override
    public LinearRingProperty createObject(QName name) throws ObjectBuildException {
        return new LinearRingProperty();
    }
}
