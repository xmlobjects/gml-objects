/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2022 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import java.util.Collections;
import java.util.List;

public class GeometricPosition extends GMLObject implements CoordinateListProvider {
    private DirectPosition pos;
    private PointProperty pointProperty;

    public GeometricPosition() {
    }

    public GeometricPosition(DirectPosition pos) {
        setPos(pos);
    }

    public GeometricPosition(PointProperty pointProperty) {
        setPointProperty(pointProperty);
    }

    public GeometricPosition(Point point) {
        this(new PointProperty(point));
    }

    public DirectPosition getPos() {
        return pos;
    }

    public boolean isSetPos() {
        return pos != null;
    }

    public void setPos(DirectPosition pos) {
        this.pos = asChild(pos);
        pointProperty = null;
    }

    public PointProperty getPointProperty() {
        return pointProperty;
    }

    public boolean isSetPointProperty() {
        return pointProperty != null;
    }

    public void setPointProperty(PointProperty pointProperty) {
        this.pointProperty = asChild( pointProperty);
        pos = null;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        if (pos != null)
            return pos.toCoordinateList3D();
        else if (pointProperty != null && pointProperty.getObject() != null)
            return pointProperty.getObject().toCoordinateList3D();
        else
            return Collections.emptyList();
    }
}
