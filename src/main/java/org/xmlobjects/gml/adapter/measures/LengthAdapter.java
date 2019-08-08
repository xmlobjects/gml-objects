package org.xmlobjects.gml.adapter.measures;

import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class LengthAdapter extends MeasureAdapter<Length> {

    @Override
    public Length createObject(QName name, Properties properties) {
        return new Length();
    }
}
