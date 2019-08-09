package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.AbstractArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SurfacePatchArrayProperty;

import javax.xml.namespace.QName;

public class SurfacePatchArrayPropertyAdapter extends AbstractArrayPropertyAdapter<SurfacePatchArrayProperty> {

    @Override
    public SurfacePatchArrayProperty createObject(QName name) {
        return new SurfacePatchArrayProperty();
    }
}
