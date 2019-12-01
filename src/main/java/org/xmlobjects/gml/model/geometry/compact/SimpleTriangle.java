package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class SimpleTriangle extends AbstractSimplePolygon {

    public SimpleTriangle() {
    }

    public SimpleTriangle(GeometricPositionList controlPoints) {
        super(controlPoints);
    }

    public SimpleTriangle(DirectPositionList posList) {
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
