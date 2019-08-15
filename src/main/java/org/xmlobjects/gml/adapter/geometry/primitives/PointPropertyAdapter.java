package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import javax.xml.namespace.QName;

public class PointPropertyAdapter extends AbstractGeometryPropertyAdapter<PointProperty> {

    @Override
    public PointProperty createObject(QName name) {
        return new PointProperty();
    }
}
