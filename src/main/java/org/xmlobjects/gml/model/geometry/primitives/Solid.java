package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Solid extends AbstractSolid {
    private ShellProperty exterior;
    private List<ShellProperty> interior;

    public Solid() {
    }

    public Solid(ShellProperty exterior) {
        setExterior(exterior);
    }

    public Solid(Shell exterior) {
        this(new ShellProperty(exterior));
    }

    public ShellProperty getExterior() {
        return exterior;
    }

    public void setExterior(ShellProperty exterior) {
        this.exterior = asChild(exterior);
    }

    public List<ShellProperty> getInterior() {
        if (interior == null)
            interior = new ChildList<>(this);

        return interior;
    }

    public void setInterior(List<ShellProperty> interior) {
        this.interior = asChild(interior);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
