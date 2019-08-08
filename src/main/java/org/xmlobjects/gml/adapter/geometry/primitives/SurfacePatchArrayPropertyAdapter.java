package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.ArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfacePatchArrayProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class SurfacePatchArrayPropertyAdapter extends ArrayPropertyAdapter<SurfacePatchArrayProperty> {

    @Override
    public SurfacePatchArrayProperty createObject(QName name, Properties properties) {
        return new SurfacePatchArrayProperty();
    }
}
