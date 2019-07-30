package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.visitor.GeometryVisitor;

import java.util.Collections;
import java.util.List;

public class Point extends AbstractGeometricPrimitive implements CoordinateListProvider {
    private DirectPosition pos;

    public Point() {
    }

    public Point(DirectPosition pos) {
        setPos(pos);
    }

    public DirectPosition getPos() {
        return pos;
    }

    public void setPos(DirectPosition pos) {
        this.pos = asChild(pos);
    }

    @Override
    public List<Double> toCoordinateList3D() {
        return pos != null ? pos.toCoordinateList3D() : Collections.emptyList();
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
