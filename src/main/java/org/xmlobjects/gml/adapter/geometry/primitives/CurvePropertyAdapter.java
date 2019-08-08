package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.GeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;

import javax.xml.namespace.QName;

public class CurvePropertyAdapter extends GeometryPropertyAdapter<CurveProperty> {

    @Override
    public CurveProperty createObject(QName name) {
        return new CurveProperty();
    }
}
