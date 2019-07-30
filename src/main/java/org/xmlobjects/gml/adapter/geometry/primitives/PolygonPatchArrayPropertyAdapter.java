package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.ArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.PolygonPatchArrayProperty;

import javax.xml.namespace.QName;

public class PolygonPatchArrayPropertyAdapter extends ArrayPropertyAdapter<PolygonPatchArrayProperty> {

    @Override
    public PolygonPatchArrayProperty createObject(QName name) {
        return new PolygonPatchArrayProperty();
    }
}
