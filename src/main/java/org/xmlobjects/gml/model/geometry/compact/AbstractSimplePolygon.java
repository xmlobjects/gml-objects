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

package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;

import java.util.List;

public abstract class AbstractSimplePolygon extends AbstractSurface {
    private GeometricPositionList controlPoints;

    public AbstractSimplePolygon() {
    }

    public AbstractSimplePolygon(GeometricPositionList controlPoints) {
        setControlPoints(controlPoints);
    }

    public AbstractSimplePolygon(DirectPositionList posList) {
        this(new GeometricPositionList(posList));
    }

    public GeometricPositionList getControlPoints() {
        if (controlPoints == null)
            controlPoints = asChild(new GeometricPositionList());

        return controlPoints;
    }

    public boolean isSetControlPoints() {
        return controlPoints != null;
    }

    public void setControlPoints(GeometricPositionList controlPoints) {
        this.controlPoints = asChild(controlPoints);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (controlPoints != null) {
            List<Double> coordinates = controlPoints.toCoordinateList3D();
            for (int i = 0; i < coordinates.size(); i += 3)
                envelope.include(coordinates.subList(i, i + 3));
        }

        return envelope;
    }
}
