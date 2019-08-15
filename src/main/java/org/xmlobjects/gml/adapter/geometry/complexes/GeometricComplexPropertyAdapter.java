package org.xmlobjects.gml.adapter.geometry.complexes;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplexProperty;

import javax.xml.namespace.QName;

public class GeometricComplexPropertyAdapter extends AbstractGeometryPropertyAdapter<GeometricComplexProperty> {

    @Override
    public GeometricComplexProperty createObject(QName name) {
        return new GeometricComplexProperty();
    }
}
