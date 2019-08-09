package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.AbstractArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.TriangleArrayProperty;

import javax.xml.namespace.QName;

public class TriangleArrayPropertyAdapter extends AbstractArrayPropertyAdapter<TriangleArrayProperty> {

    @Override
    public TriangleArrayProperty createObject(QName name) {
        return new TriangleArrayProperty();
    }
}
