package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import javax.xml.namespace.QName;

public class SurfacePropertyAdapter extends GeometryPropertyAdapter<SurfaceProperty> {

    @Override
    public SurfaceProperty createObject(QName name) {
        return new SurfaceProperty();
    }
}
