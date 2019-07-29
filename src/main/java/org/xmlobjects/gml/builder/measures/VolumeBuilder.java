package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basictypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.Volume;

import javax.xml.namespace.QName;

public class VolumeBuilder extends MeasureBuilder<Volume> {

    @Override
    public Volume createObject(QName name) {
        return new Volume();
    }
}
