package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Time;

import javax.xml.namespace.QName;

public class TimeAdapter extends MeasureAdapter<Time> {

    @Override
    public Time createObject(QName name) {
        return new Time();
    }
}
