/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.deprecated;

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
