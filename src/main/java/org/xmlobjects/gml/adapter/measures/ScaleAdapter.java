package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.AbstractMeasureAdapter;
import org.xmlobjects.gml.model.measures.Scale;

import javax.xml.namespace.QName;

public class ScaleAdapter extends AbstractMeasureAdapter<Scale> {

    @Override
    public Scale createObject(QName name) {
        return new Scale();
    }
}
