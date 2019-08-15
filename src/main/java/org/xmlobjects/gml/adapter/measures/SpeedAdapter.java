package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.AbstractMeasureAdapter;
import org.xmlobjects.gml.model.measures.Speed;

import javax.xml.namespace.QName;

public class SpeedAdapter extends AbstractMeasureAdapter<Speed> {

    @Override
    public Speed createObject(QName name) {
        return new Speed();
    }
}
