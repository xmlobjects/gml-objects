package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.AbstractMeasureAdapter;
import org.xmlobjects.gml.model.measures.Volume;

import javax.xml.namespace.QName;

public class VolumeAdapter extends AbstractMeasureAdapter<Volume> {

    @Override
    public Volume createObject(QName name) {
        return new Volume();
    }
}
