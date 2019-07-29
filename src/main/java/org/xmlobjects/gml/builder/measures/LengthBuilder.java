package org.xmlobjects.gml.builder.measures;

import org.xmlobjects.gml.builder.basictypes.MeasureBuilder;
import org.xmlobjects.gml.model.measures.Length;

import javax.xml.namespace.QName;

public class LengthBuilder extends MeasureBuilder<Length> {

    @Override
    public Length createObject(QName name) {
        return new Length();
    }
}
