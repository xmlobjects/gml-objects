package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.model.ChildList;

import java.util.List;

public abstract class AbstractArrayProperty<T extends GMLObject> extends AbstractAssociation<T> {
    private List<T> objects;

    public AbstractArrayProperty() {
    }

    public AbstractArrayProperty(List<T> objects) {
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
