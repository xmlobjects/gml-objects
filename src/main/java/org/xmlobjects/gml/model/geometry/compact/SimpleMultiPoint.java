package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.aggregates.AbstractMultiPoint;
import org.xmlobjects.gml.visitor.GeometryVisitor;

public class SimpleMultiPoint extends AbstractMultiPoint {
    private DirectPositionList posList;

    public SimpleMultiPoint() {
    }

    public SimpleMultiPoint(DirectPositionList posList) {
        setPosList(posList);
    }

    public DirectPositionList getPosList() {
        return posList;
    }

    public void setPosList(DirectPositionList posList) {
        this.posList = asChild(posList);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
