package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiGeometryProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class MultiGeometryPropertyAdapter extends GeometryPropertyAdapter<MultiGeometryProperty> {

    @Override
    public MultiGeometryProperty createObject(QName name, Properties properties) {
        return new MultiGeometryProperty();
    }
}
