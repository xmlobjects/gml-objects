package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AbstractProperty;

public abstract class AbstractDomainSet<T extends AbstractGML> extends AbstractProperty<T> {

    public AbstractDomainSet() {
    }

    public AbstractDomainSet(T object) {
        super(object);
    }

    public AbstractDomainSet(String href) {
        super(href);
    }
}
