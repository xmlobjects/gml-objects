package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.AbstractArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.PolygonPatchArrayProperty;

import javax.xml.namespace.QName;

public class PolygonPatchArrayPropertyAdapter extends AbstractArrayPropertyAdapter<PolygonPatchArrayProperty> {

    @Override
    public PolygonPatchArrayProperty createObject(QName name) {
        return new PolygonPatchArrayProperty();
    }
}
