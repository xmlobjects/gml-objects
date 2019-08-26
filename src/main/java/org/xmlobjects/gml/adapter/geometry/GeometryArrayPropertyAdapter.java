package org.xmlobjects.gml.adapter.geometry;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;

import javax.xml.namespace.QName;

public class GeometryArrayPropertyAdapter extends AbstractGeometryArrayPropertyAdapter<GeometryArrayProperty<AbstractGeometry>> {

    @Override
    public GeometryArrayProperty<AbstractGeometry> createObject(QName name) throws ObjectBuildException {
        return new GeometryArrayProperty<>();
    }
}
