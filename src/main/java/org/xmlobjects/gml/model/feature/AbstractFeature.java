package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.deprecated.LocationProperty;

public abstract class AbstractFeature extends AbstractGML {
    private BoundingShape boundedBy;
    private LocationProperty location;

    public BoundingShape getBoundedBy() {
        return boundedBy;
    }

    public void setBoundedBy(BoundingShape boundedBy) {
        this.boundedBy = asChild(boundedBy);
    }

    public LocationProperty getLocation() {
        return location;
    }

    public void setLocation(LocationProperty location) {
        this.location = asChild(location);
    }
}
