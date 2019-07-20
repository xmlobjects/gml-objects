package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basicTypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.Area;

import javax.xml.namespace.QName;

public class AreaBuilder extends MeasureBuilder<Area> {

    @Override
    public Area createObject(QName name) {
        return new Area();
    }
}
