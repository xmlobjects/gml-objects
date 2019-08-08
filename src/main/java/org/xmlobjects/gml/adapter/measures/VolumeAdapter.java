package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Volume;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class VolumeAdapter extends MeasureAdapter<Volume> {

    @Override
    public Volume createObject(QName name) {
        return new Volume();
    }
}
