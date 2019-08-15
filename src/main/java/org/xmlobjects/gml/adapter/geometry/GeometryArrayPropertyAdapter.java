package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;

import javax.xml.namespace.QName;

public class GeometryArrayPropertyAdapter extends AbstractGeometryArrayPropertyAdapter<GeometryArrayProperty> {

    @Override
    public GeometryArrayProperty createObject(QName name) throws ObjectBuildException {
        return new GeometryArrayProperty();
    }
}
