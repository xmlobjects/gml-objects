package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basicTypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.Speed;

import javax.xml.namespace.QName;

public class SpeedBuilder extends MeasureBuilder<Speed> {

    @Override
    public Speed createObject(QName name) {
        return new Speed();
    }
}
