package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import javax.xml.namespace.QName;

public class SurfacePropertyAdapter extends AbstractGeometryPropertyAdapter<SurfaceProperty> {

    @Override
    public SurfaceProperty createObject(QName name) {
        return new SurfaceProperty();
    }
}
