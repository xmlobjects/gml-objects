package org.xmlobjects.gml.model.deprecatedTypes;

import org.xmlobjects.gml.model.common.ModelObject;

public abstract class AbstractMetaData extends ModelObject {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
