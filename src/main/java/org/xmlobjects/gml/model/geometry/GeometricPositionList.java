package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.model.ChildList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GeometricPositionList extends GMLObject implements CoordinateListProvider {
    private DirectPositionList posList;
    private List<GeometricPosition> geometricPositions;

    public GeometricPositionList() {
    }

    public GeometricPositionList(DirectPositionList posList) {
        setPosList(posList);
    }

    public GeometricPositionList(List<GeometricPosition> geometricPositions) {
        setGeometricPositions(geometricPositions);
    }

    public DirectPositionList getPosList() {
        return posList;
    }

    public boolean isSetPosList() {
        return posList != null;
    }

    public void setPosList(DirectPositionList posList) {
        this.posList = asChild(posList);
        geometricPositions = null;
    }

    public List<GeometricPosition> getGeometricPositions() {
        if (geometricPositions == null)
            geometricPositions = new ChildList<>(this);

        return geometricPositions;
    }

    public boolean isSetGeometricPositions() {
        return geometricPositions != null && !geometricPositions.isEmpty();
    }

    public void setGeometricPositions(List<GeometricPosition> geometricPositions) {
        this.geometricPositions = asChild(geometricPositions);
        posList = null;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        if (isSetPosList())
            return posList.toCoordinateList3D();
        else if (isSetGeometricPositions())
            return geometricPositions.stream()
                    .map(GeometricPosition::toCoordinateList3D)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        else
            return Collections.emptyList();
    }
}
