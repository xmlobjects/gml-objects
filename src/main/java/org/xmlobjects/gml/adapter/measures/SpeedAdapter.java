package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Speed;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class SpeedAdapter extends MeasureAdapter<Speed> {

    @Override
    public Speed createObject(QName name, Properties properties) {
        return new Speed();
    }
}
