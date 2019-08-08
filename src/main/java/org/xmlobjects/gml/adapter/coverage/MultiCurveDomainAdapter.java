package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiCurveDomain;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class MultiCurveDomainAdapter extends AbstractPropertyAdapter<MultiCurveDomain> {

    @Override
    public MultiCurveDomain createObject(QName name) {
        return new MultiCurveDomain();
    }
}
