package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceArrayProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class SurfaceArrayPropertyAdapter extends GeometryArrayPropertyAdapter<SurfaceArrayProperty> {

    @Override
    public SurfaceArrayProperty createObject(QName name, Properties properties) {
        return new SurfaceArrayProperty();
    }
}
