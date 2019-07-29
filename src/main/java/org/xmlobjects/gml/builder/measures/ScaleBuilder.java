package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basictypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.Scale;

import javax.xml.namespace.QName;

public class ScaleBuilder extends MeasureBuilder<Scale> {

    @Override
    public Scale createObject(QName name) {
        return new Scale();
    }
}
