package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basictypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.Angle;

import javax.xml.namespace.QName;

public class AngleBuilder extends MeasureBuilder<Angle> {

    @Override
    public Angle createObject(QName name) {
        return new Angle();
    }
}
