package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometryProperty;

import javax.xml.namespace.QName;

public class MultiGeometryPropertyAdapter extends GeometryPropertyAdapter<MultiGeometryProperty> {

    @Override
    public MultiGeometryProperty createObject(QName name) {
        return new MultiGeometryProperty();
    }
}