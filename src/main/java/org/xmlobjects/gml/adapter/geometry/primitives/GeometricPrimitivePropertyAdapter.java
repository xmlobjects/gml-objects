package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.GeometricPrimitiveProperty;

import javax.xml.namespace.QName;

public class GeometricPrimitivePropertyAdapter extends AbstractGeometryPropertyAdapter<GeometricPrimitiveProperty> {

    @Override
    public GeometricPrimitiveProperty createObject(QName name) throws ObjectBuildException {
        return new GeometricPrimitiveProperty();
    }
}
