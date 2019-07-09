package org.citygml4j.gmlobjects.model.common;

import java.io.Serializable;
import java.util.List;

public abstract class ModelObject implements Serializable {
    private static final long serialVersionUID = 8038430725115673854L;
    private ModelObject parent;

    protected final <T extends ModelObject> T asChild(T child) {
        if (child != null)
            child.setParent(this);

        return child;
    }

    protected final <T extends ModelObject> List<T> asChild(List<T> child) {
        return child != null ? new ChildList<>(child, this) : null;
    }

    public final ModelObject getParent() {
        return parent;
    }

    public final void setParent(ModelObject parent) {
        this.parent = parent;
    }
}
