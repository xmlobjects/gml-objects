package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.AbstractMeasureAdapter;
import org.xmlobjects.gml.model.measures.Length;

import javax.xml.namespace.QName;

public class LengthAdapter extends AbstractMeasureAdapter<Length> {

    @Override
    public Length createObject(QName name) throws ObjectBuildException {
        return new Length();
    }
}
