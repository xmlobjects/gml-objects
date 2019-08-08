package org.xmlobjects.gml.adapter.geometry.complexes;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplexProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class GeometricComplexPropertyAdapter extends GeometryPropertyAdapter<GeometricComplexProperty> {

    @Override
    public GeometricComplexProperty createObject(QName name) {
        return new GeometricComplexProperty();
    }
}
