package org.citygml4j.gmlobjects.model.deprecatedTypes;

import org.citygml4j.gmlobjects.model.common.ModelObject;

public abstract class AbstractMetaData extends ModelObject {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
