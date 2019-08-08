package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiSolidDomain;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class MultiSolidDomainAdapter extends AbstractPropertyAdapter<MultiSolidDomain> {

    @Override
    public MultiSolidDomain createObject(QName name, Properties properties) {
        return new MultiSolidDomain();
    }
}
