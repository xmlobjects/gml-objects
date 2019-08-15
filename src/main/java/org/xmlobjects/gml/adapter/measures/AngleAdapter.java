package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.AbstractMeasureAdapter;
import org.xmlobjects.gml.model.measures.Angle;

import javax.xml.namespace.QName;


public class AngleAdapter extends AbstractMeasureAdapter<Angle> {

    @Override
    public Angle createObject(QName name) {
        return new Angle();
    }
}
