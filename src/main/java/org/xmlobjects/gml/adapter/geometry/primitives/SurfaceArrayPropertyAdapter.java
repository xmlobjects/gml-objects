package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceArrayProperty;

import javax.xml.namespace.QName;

public class SurfaceArrayPropertyAdapter extends AbstractGeometryArrayPropertyAdapter<SurfaceArrayProperty> {

    @Override
    public SurfaceArrayProperty createObject(QName name) {
        return new SurfaceArrayProperty();
    }
}
