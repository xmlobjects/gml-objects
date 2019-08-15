package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.SolidArrayProperty;

import javax.xml.namespace.QName;

public class SolidArrayPropertyAdapter extends AbstractGeometryArrayPropertyAdapter<SolidArrayProperty> {

    @Override
    public SolidArrayProperty createObject(QName name) {
        return new SolidArrayProperty();
    }
}
