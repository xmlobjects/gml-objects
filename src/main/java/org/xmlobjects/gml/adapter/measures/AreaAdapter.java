package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.AbstractMeasureAdapter;
import org.xmlobjects.gml.model.measures.Area;

import javax.xml.namespace.QName;

public class AreaAdapter extends AbstractMeasureAdapter<Area> {

    @Override
    public Area createObject(QName name) {
        return new Area();
    }
}
