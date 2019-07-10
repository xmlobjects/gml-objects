package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.common.LocalProperties;

import java.util.List;

public abstract class ArrayProperty<T extends GMLObject> extends GMLObject implements OwnershipAttributes {
    private List<T> objects;
    private Boolean owns;
    private LocalProperties localProperties;

    protected ArrayProperty() {
    }

    protected ArrayProperty(List<T> objects) {
        setObjects(objects);
    }

    public abstract Class<T> getTargetType();

    public List<T> getObjects() {
        if (objects == null)
            objects = new ChildList<>(this);

        return objects;
    }

    public void setObjects(List<T> object) {
        this.objects = asChild(objects);
    }

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }
}
