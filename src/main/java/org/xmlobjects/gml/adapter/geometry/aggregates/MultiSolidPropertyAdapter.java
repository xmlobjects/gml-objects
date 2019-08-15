package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSolidProperty;

import javax.xml.namespace.QName;

public class MultiSolidPropertyAdapter extends AbstractGeometryPropertyAdapter<MultiSolidProperty> {

    @Override
    public MultiSolidProperty createObject(QName name) {
        return new MultiSolidProperty();
    }
}
