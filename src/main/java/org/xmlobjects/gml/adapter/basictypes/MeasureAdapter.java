package org.xmlobjects.gml.adapter.basictypes;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.model.basictypes.Measure;

import javax.xml.namespace.QName;

public class MeasureAdapter extends AbstractMeasureAdapter<Measure> {

    @Override
    public Measure createObject(QName name) throws ObjectBuildException {
        return new Measure();
    }
}
