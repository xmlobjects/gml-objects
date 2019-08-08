package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiSurfaceDomain;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class MultiSurfaceDomainAdapter extends AbstractPropertyAdapter<MultiSurfaceDomain> {

    @Override
    public MultiSurfaceDomain createObject(QName name, Properties properties) {
        return new MultiSurfaceDomain();
    }
}
