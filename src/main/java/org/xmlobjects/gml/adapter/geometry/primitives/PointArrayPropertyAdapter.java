package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.PointArrayProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class PointArrayPropertyAdapter extends GeometryArrayPropertyAdapter<PointArrayProperty> {

    @Override
    public PointArrayProperty createObject(QName name, Properties properties) {
        return new PointArrayProperty();
    }
}
