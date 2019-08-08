package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiSurfaceDomain;

import javax.xml.namespace.QName;

public class MultiSurfaceDomainAdapter extends AbstractPropertyAdapter<MultiSurfaceDomain> {

    @Override
    public MultiSurfaceDomain createObject(QName name) {
        return new MultiSurfaceDomain();
    }
}
