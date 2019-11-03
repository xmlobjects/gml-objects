package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.AbstractMeasureAdapter;
import org.xmlobjects.gml.model.measures.GridLength;

import javax.xml.namespace.QName;

public class GridLengthAdapter extends AbstractMeasureAdapter<GridLength> {

    @Override
    public GridLength createObject(QName name) throws ObjectBuildException {
        return new GridLength();
    }
}
