package org.xmlobjects.gml.model.geometry.aggregates;

import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class MultiGeometry extends AbstractGeometricAggregate {
    private List<GeometryProperty> geometryMember;
    private GeometryArrayProperty geometryMembers;

    public MultiGeometry() {
    }

    public MultiGeometry(List<GeometryProperty> geometryMember) {
        setGeometryMember(geometryMember);
    }

    public List<GeometryProperty> getGeometryMember() {
        if (geometryMember == null)
            geometryMember = new ChildList<>(this);

        return geometryMember;
    }

    public void setGeometryMember(List<GeometryProperty> geometryMember) {
        this.geometryMember = asChild(geometryMember);
    }

    public GeometryArrayProperty getGeometryMembers() {
        return geometryMembers;
    }

    public void setGeometryMembers(GeometryArrayProperty geometryMembers) {
        this.geometryMembers = asChild(geometryMembers);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
