package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;

import javax.xml.namespace.QName;

public class MultiCurvePropertyAdapter extends AbstractGeometryPropertyAdapter<MultiCurveProperty> {

    @Override
    public MultiCurveProperty createObject(QName name) {
        return new MultiCurveProperty();
    }
}
