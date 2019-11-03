package org.xmlobjects.gml.adapter.coverage;

import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.gml.model.coverage.MultiSolidDomain;

import javax.xml.namespace.QName;

public class MultiSolidDomainAdapter extends AbstractPropertyAdapter<MultiSolidDomain> {

    @Override
    public MultiSolidDomain createObject(QName name) throws ObjectBuildException {
        return new MultiSolidDomain();
    }
}
