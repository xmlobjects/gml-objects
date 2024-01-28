/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
