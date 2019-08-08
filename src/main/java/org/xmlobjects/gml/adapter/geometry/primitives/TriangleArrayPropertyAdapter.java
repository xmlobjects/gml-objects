package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.base.ArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.TriangleArrayProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class TriangleArrayPropertyAdapter extends ArrayPropertyAdapter<TriangleArrayProperty> {

    @Override
    public TriangleArrayProperty createObject(QName name, Properties properties) {
        return new TriangleArrayProperty();
    }
}
