package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.GridLength;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class GridLengthAdapter extends MeasureAdapter<GridLength> {

    @Override
    public GridLength createObject(QName name) {
        return new GridLength();
    }
}
