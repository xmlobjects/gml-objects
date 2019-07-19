package org.xmlobjects.gml.model.deprecatedTypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.DirectPosition;

import java.util.ArrayList;
import java.util.List;

public class Coord extends GMLObject implements CoordinateListProvider {
    private Double x;
    private Double y;
    private Double z;

    public Coord() {
    }

    public Coord(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public DirectPosition toDirectPosition() {
        List<Double> pos = new ArrayList<>(3);
        pos.add(x != null ? x : 0);
        if (y != null) {
            pos.add(y);
            if (z != null)
                pos.add(z);
        }

        return new DirectPosition(pos);
    }

    @Override
    public List<Double> toCoordinateList3D() {
        List<Double> coordinates = new ArrayList<>(3);
        coordinates.add(x != null ? x : 0);
        coordinates.add(y != null ? y : 0);
        coordinates.add(z != null ? z : 0);
        return coordinates;
    }
}
