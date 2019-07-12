package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class ArrayProperty<T extends GMLObject> extends Association<T> {
    private List<T> objects;

    protected ArrayProperty() {
    }

    protected ArrayProperty(List<T> objects) {
        setObjects(objects);
    }

    public List<T> getObjects() {
        if (objects == null)
            objects = new ChildList<>(this);

        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = asChild(objects);
    }
}
