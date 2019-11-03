package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiCurveDomain;

import javax.xml.namespace.QName;

public class MultiCurveDomainAdapter extends AbstractPropertyAdapter<MultiCurveDomain> {

    @Override
    public MultiCurveDomain createObject(QName name) throws ObjectBuildException {
        return new MultiCurveDomain();
    }
}
