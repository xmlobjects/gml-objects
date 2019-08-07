package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.visitor.GeometryVisitor;

public class SimplePolygon extends AbstractSimplePolygon {

    public SimplePolygon() {
    }

    public SimplePolygon(GeometricPositionList controlPoints) {
        super(controlPoints);
    }

    public SimplePolygon(DirectPositionList posList) {
        super(posList);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
