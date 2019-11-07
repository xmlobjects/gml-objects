package org.xmlobjects.gml.adapter.temporal;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.temporal.TimeInstantProperty;

import javax.xml.namespace.QName;

public class TimeInstantPropertyAdapter extends AbstractPropertyAdapter<TimeInstantProperty> {

    @Override
    public TimeInstantProperty createObject(QName name) throws ObjectBuildException {
        return new TimeInstantProperty();
    }
}
