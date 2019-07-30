package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Angle;

import javax.xml.namespace.QName;

public class AngleAdapter extends MeasureAdapter<Angle> {

    @Override
    public Angle createObject(QName name) {
        return new Angle();
    }
}