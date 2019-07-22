package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.gml.model.deprecatedTypes.LocationProperty;

import java.util.List;

public abstract class AbstractFeature extends AbstractGML {
    private BoundingShape boundedBy;
    private LocationProperty location;
    private List<GenericElement> genericProperties;

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

    public List<GenericElement> getGenericProperties() {
        if (genericProperties == null)
            genericProperties = new ChildList<>(this);

        return genericProperties;
    }

    public void setGenericProperties(List<GenericElement> genericProperties) {
        this.genericProperties = asChild(genericProperties);
    }
}
