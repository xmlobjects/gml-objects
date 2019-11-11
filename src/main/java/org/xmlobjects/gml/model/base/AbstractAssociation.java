package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.LocalProperties;
import org.xmlobjects.model.Child;

public abstract class AbstractAssociation<T extends Child> extends GMLObject {
    private LocalProperties localProperties;

    public abstract Class<T> getTargetType();

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }
}
