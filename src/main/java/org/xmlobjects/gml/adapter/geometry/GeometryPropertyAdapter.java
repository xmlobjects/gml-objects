package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

import javax.xml.namespace.QName;

public class GeometryPropertyAdapter extends AbstractGeometryPropertyAdapter<GeometryProperty> {

    @Override
    public GeometryProperty createObject(QName name) {
        return new GeometryProperty<>();
    }
}
