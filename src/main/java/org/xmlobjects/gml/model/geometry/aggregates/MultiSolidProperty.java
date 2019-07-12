package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryProperty;

public class MultiSolidProperty extends GeometryProperty<MultiSolid> {

    public MultiSolidProperty() {
    }

    public MultiSolidProperty(MultiSolid multiSolid) {
        super(multiSolid);
    }

    public MultiSolidProperty(String href) {
        super(href);
    }

    @Override
    public Class<MultiSolid> getTargetType() {
        return MultiSolid.class;
    }
}
