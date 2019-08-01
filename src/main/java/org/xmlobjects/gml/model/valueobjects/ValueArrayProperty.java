package org.xmlobjects.gml.model.valueobjects;

import org.xmlobjects.gml.model.base.ArrayProperty;
import org.xmlobjects.gml.model.base.OwnershipAttributes;

import java.util.List;

public class ValueArrayProperty extends ArrayProperty<Value> implements OwnershipAttributes {
    private Boolean owns;

    public ValueArrayProperty() {
    }

    public ValueArrayProperty(List<Value> objects) {
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

    @Override
    public Class<Value> getTargetType() {
        return Value.class;
    }
}
