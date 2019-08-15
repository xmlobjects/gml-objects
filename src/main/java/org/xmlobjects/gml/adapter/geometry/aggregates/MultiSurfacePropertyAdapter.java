package org.xmlobjects.gml.adapter.geometry.aggregates;

import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

import javax.xml.namespace.QName;

public class MultiSurfacePropertyAdapter extends AbstractGeometryPropertyAdapter<MultiSurfaceProperty> {

    @Override
    public MultiSurfaceProperty createObject(QName name) {
        return new MultiSurfaceProperty();
    }
}
