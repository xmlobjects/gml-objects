package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basicTypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.Time;

import javax.xml.namespace.QName;

public class TimeBuilder extends MeasureBuilder<Time> {

    @Override
    public Time createObject(QName name) {
        return new Time();
    }
}
