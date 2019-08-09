package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.AbstractArrayProperty;
import org.xmlobjects.gml.model.base.OwnershipAttributes;

import java.util.List;

public class GeometryArrayProperty<T extends AbstractGeometry> extends AbstractArrayProperty<T> implements OwnershipAttributes {
    private Boolean owns;

    public GeometryArrayProperty() {
    }

    public GeometryArrayProperty(List<T> objects) {
        super(objects);
    }

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractGeometry.class;
    }
}
