package org.xmlobjects.gml.model.deprecatedTypes;

import org.xmlobjects.gml.model.GMLObject;

public abstract class AbstractMetaData extends GMLObject {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
