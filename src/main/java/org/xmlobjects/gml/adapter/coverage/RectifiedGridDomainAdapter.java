package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.RectifiedGridDomain;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class RectifiedGridDomainAdapter extends AbstractPropertyAdapter<RectifiedGridDomain> {

    @Override
    public RectifiedGridDomain createObject(QName name, Properties properties) {
        return new RectifiedGridDomain();
    }
}
