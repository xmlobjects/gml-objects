package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basictypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.GridLength;

import javax.xml.namespace.QName;

public class GridLengthBuilder extends MeasureBuilder<GridLength> {

    @Override
    public GridLength createObject(QName name) {
        return new GridLength();
    }
}
