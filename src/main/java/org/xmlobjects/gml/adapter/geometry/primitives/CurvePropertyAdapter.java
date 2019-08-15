package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.CurveProperty;

import javax.xml.namespace.QName;

public class CurvePropertyAdapter extends AbstractGeometryPropertyAdapter<CurveProperty> {

    @Override
    public CurveProperty createObject(QName name) {
        return new CurveProperty();
    }
}
