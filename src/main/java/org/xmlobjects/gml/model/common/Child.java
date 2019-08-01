package org.xmlobjects.gml.model.common;

import org.xmlobjects.gml.model.GMLObject;

import java.io.Serializable;

public interface Child extends Serializable {
    GMLObject getParent();
    void setParent(GMLObject parent);
}
