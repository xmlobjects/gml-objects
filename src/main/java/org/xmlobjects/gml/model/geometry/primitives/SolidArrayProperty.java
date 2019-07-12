package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;

import java.util.List;

public class SolidArrayProperty extends GeometryArrayProperty<AbstractSolid> {

    public SolidArrayProperty() {
    }

    public SolidArrayProperty(List<AbstractSolid> solids) {
        super(solids);
    }

    @Override
    public Class<AbstractSolid> getTargetType() {
        return AbstractSolid.class;
    }
}
