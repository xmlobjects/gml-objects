package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

import javax.xml.namespace.QName;

public class GeometryPropertyAdapter extends AbstractGeometryPropertyAdapter<GeometryProperty> {

    @Override
    public GeometryProperty createObject(QName name) throws ObjectBuildException {
        return new GeometryProperty<>();
    }
}
