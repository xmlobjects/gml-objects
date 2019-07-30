package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolidProperty;

import javax.xml.namespace.QName;

public class MultiSolidPropertyAdapter extends GeometryPropertyAdapter<MultiSolidProperty> {

    @Override
    public MultiSolidProperty createObject(QName name) {
        return new MultiSolidProperty();
    }
}
