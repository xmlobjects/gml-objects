package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.primitives.PointArrayProperty;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiPoint extends AbstractMultiPoint {
    private List<PointProperty> pointMember;
    private PointArrayProperty pointMembers;

    public MultiPoint() {
    }

    public MultiPoint(List<PointProperty> pointMember) {
        setPointMember(pointMember);
    }

    public List<PointProperty> getPointMember() {
        if (pointMember == null)
            pointMember = new ChildList<>(this);

        return pointMember;
    }

    public void setPointMember(List<PointProperty> pointMember) {
        this.pointMember = asChild(pointMember);
    }

    public PointArrayProperty getPointMembers() {
        return pointMembers;
    }

    public void setPointMembers(PointArrayProperty pointMembers) {
        this.pointMembers = asChild(pointMembers);
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
