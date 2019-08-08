package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiPointDomain;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class MultiPointDomainAdapter extends AbstractPropertyAdapter<MultiPointDomain> {

    @Override
    public MultiPointDomain createObject(QName name) {
        return new MultiPointDomain();
    }
}
