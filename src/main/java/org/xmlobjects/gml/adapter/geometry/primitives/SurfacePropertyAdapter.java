package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class SurfacePropertyAdapter extends GeometryPropertyAdapter<SurfaceProperty> {

    @Override
    public SurfaceProperty createObject(QName name, Properties properties) {
        return new SurfaceProperty();
    }
}
