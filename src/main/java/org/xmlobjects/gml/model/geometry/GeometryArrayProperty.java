package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.base.ArrayProperty;
import org.xmlobjects.gml.model.base.OwnershipAttributes;

import java.util.List;

public class GeometryArrayProperty<T extends AbstractGeometry> extends ArrayProperty<T> implements OwnershipAttributes {
    private Boolean owns;

    public GeometryArrayProperty() {
    }

    public GeometryArrayProperty(List<T> objects) {
        super(objects);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getTargetType() {
        return (Class<T>) AbstractGeometry.class;
    }

    @Override
    public Boolean getOwns() {
        return owns;
    }

    @Override
    public void setOwns(Boolean owns) {
        this.owns = owns;
    }
}
