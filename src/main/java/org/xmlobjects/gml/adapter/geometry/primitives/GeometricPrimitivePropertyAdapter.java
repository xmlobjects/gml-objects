package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;

import javax.xml.namespace.QName;

public class GeometricPrimitivePropertyAdapter extends GeometryPropertyAdapter<GeometricPrimitiveProperty> {

    @Override
    public GeometricPrimitiveProperty createObject(QName name) {
        return new GeometricPrimitiveProperty();
    }
}
