package org.xmlobjects.gml.adapter.geometry.primitives;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractArrayPropertyAdapter;
import org.xmlobjects.gml.model.geometry.primitives.CurveSegmentArrayProperty;

import javax.xml.namespace.QName;

public class CurveSegmentArrayPropertyAdapter extends AbstractArrayPropertyAdapter<CurveSegmentArrayProperty> {

    @Override
    public CurveSegmentArrayProperty createObject(QName name) throws ObjectBuildException {
        return new CurveSegmentArrayProperty();
    }
}
