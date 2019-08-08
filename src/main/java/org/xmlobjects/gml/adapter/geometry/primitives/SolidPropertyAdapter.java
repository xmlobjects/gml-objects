package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class SolidPropertyAdapter extends GeometryPropertyAdapter<SolidProperty> {

    @Override
    public SolidProperty createObject(QName name, Properties properties) {
        return new SolidProperty();
    }
}
