package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.visitor.GeometryVisitor;

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
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
