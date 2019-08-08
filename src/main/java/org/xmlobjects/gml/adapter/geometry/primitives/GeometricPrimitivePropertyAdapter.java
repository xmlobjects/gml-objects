package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class GeometricPrimitivePropertyAdapter extends GeometryPropertyAdapter<GeometricPrimitiveProperty> {

    @Override
    public GeometricPrimitiveProperty createObject(QName name, Properties properties) {
        return new GeometricPrimitiveProperty();
    }
}
