package org.xmlobjects.gml.model;

import org.xmlobjects.gml.model.common.ChildList;

import java.io.Serializable;
import java.util.List;

public abstract class GMLObject implements Serializable {
    private static final long serialVersionUID = 8038430725115673854L;
    private GMLObject parent;

    protected final <T extends GMLObject> T asChild(T child) {
        if (child != null)
            child.setParent(this);

        return child;
    }

    protected final <T extends GMLObject> List<T> asChild(List<T> child) {
        return child != null ? new ChildList<>(child, this) : null;
    }

    public final GMLObject getParent() {
        return parent;
    }

    public final void setParent(GMLObject parent) {
        this.parent = parent;
    }
}
