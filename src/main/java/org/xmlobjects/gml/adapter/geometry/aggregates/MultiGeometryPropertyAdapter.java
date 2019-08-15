package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometryProperty;

import javax.xml.namespace.QName;

public class MultiGeometryPropertyAdapter extends AbstractGeometryPropertyAdapter<MultiGeometryProperty> {

    @Override
    public MultiGeometryProperty createObject(QName name) {
        return new MultiGeometryProperty();
    }
}
