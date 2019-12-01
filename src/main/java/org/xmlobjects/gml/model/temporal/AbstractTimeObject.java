package org.xmlobjects.gml.model.temporal;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public abstract class AbstractTimeObject extends AbstractGML {
    public abstract void accept(ObjectVisitor visitor);
}
