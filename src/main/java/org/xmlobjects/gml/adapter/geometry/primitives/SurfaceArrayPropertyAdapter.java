package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceArrayProperty;

import javax.xml.namespace.QName;

public class SurfaceArrayPropertyAdapter extends GeometryArrayPropertyAdapter<SurfaceArrayProperty> {

    @Override
    public SurfaceArrayProperty createObject(QName name) {
        return new SurfaceArrayProperty();
    }
}