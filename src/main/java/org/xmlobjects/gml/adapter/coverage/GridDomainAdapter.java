package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.GridDomain;
import org.xmlobjects.util.Properties;

import javax.xml.namespace.QName;

public class GridDomainAdapter extends AbstractPropertyAdapter<GridDomain> {

    @Override
    public GridDomain createObject(QName name, Properties properties) {
        return new GridDomain();
    }
}
