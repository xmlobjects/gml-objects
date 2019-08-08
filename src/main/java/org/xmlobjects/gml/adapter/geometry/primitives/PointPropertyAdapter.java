package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class PointPropertyAdapter extends GeometryPropertyAdapter<PointProperty> {

    @Override
    public PointProperty createObject(QName name) {
        return new PointProperty();
    }
}
