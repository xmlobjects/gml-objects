package org.xmlobjects.gml.model;

import org.xmlobjects.gml.model.common.Child;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class GMLObject implements Child {
    private GMLObject parent;

    protected final <T extends Child> T asChild(T child) {
        if (child != null)
            child.setParent(this);

        return child;
    }

    protected final <T extends Child> List<T> asChild(List<T> child) {
        if (child instanceof ChildList) {
            ((ChildList<T>) child).setParent(this);
            return child;
        } else
            return child != null ? new ChildList<>(child, this) : null;
    }

    @Override
    public final GMLObject getParent() {
        return parent;
    }

    @Override
    public final void setParent(GMLObject parent) {
        this.parent = parent;
    }
}
