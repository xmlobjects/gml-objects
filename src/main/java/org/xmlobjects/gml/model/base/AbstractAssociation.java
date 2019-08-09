package org.xmlobjects.gml.model.base;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.LocalProperties;

public abstract class AbstractAssociation<T extends GMLObject> extends GMLObject {
    private LocalProperties localProperties;

    public abstract Class<T> getTargetType();

    public LocalProperties getLocalProperties() {
        if (localProperties == null)
            localProperties = new LocalProperties();

        return localProperties;
    }
}
