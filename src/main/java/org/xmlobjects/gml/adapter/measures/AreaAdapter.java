package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Area;

import javax.xml.namespace.QName;

public class AreaAdapter extends MeasureAdapter<Area> {

    @Override
    public Area createObject(QName name) {
        return new Area();
    }
}
