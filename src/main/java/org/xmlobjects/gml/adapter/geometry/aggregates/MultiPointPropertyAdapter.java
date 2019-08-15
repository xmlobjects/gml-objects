package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;

import javax.xml.namespace.QName;

public class MultiPointPropertyAdapter extends AbstractGeometryPropertyAdapter<MultiPointProperty> {

    @Override
    public MultiPointProperty createObject(QName name) {
        return new MultiPointProperty();
    }
}
