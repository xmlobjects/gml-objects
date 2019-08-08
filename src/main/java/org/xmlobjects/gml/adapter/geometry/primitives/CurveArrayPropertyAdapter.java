package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.CurveArrayProperty;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class CurveArrayPropertyAdapter extends GeometryArrayPropertyAdapter<CurveArrayProperty> {

    @Override
    public CurveArrayProperty createObject(QName name) {
        return new CurveArrayProperty();
    }
}
