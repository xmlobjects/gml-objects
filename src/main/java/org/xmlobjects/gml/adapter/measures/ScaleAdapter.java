package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Scale;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class ScaleAdapter extends MeasureAdapter<Scale> {

    @Override
    public Scale createObject(QName name) {
        return new Scale();
    }
}
