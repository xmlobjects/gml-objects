package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class MultiPointPropertyAdapter extends GeometryPropertyAdapter<MultiPointProperty> {

    @Override
    public MultiPointProperty createObject(QName name) {
        return new MultiPointProperty();
    }
}
