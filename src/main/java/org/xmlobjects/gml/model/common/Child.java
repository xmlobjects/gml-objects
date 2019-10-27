package org.xmlobjects.gml.model.common;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.util.copy.Copyable;

import java.io.Serializable;

public interface Child extends Copyable, Serializable {
    GMLObject getParent();
    void setParent(GMLObject parent);
}
