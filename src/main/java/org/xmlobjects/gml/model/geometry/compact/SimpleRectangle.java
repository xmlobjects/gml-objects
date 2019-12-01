package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class SimpleRectangle extends AbstractSimplePolygon {

    public SimpleRectangle() {
    }

    public SimpleRectangle(GeometricPositionList controlPoints) {
        super(controlPoints);
    }

    public SimpleRectangle(DirectPositionList posList) {
        super(posList);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
