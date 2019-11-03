package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.GridDomain;

import javax.xml.namespace.QName;

public class GridDomainAdapter extends AbstractPropertyAdapter<GridDomain> {

    @Override
    public GridDomain createObject(QName name) throws ObjectBuildException {
        return new GridDomain();
    }
}
