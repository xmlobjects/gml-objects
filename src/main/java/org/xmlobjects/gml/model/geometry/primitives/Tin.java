/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.GeometricPositionList;
import org.xmlobjects.gml.model.measures.Length;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class Tin extends TriangulatedSurface {
    private List<LineStringSegmentArrayProperty> stopLines;
    private List<LineStringSegmentArrayProperty> breakLines;
    private Length maxLength;
    private GeometricPositionList controlPoints;

    public List<LineStringSegmentArrayProperty> getStopLines() {
        if (stopLines == null)
            stopLines = new ChildList<>(this);

        return stopLines;
    }

    public void setStopLines(List<LineStringSegmentArrayProperty> stopLines) {
        this.stopLines = asChild(stopLines);
    }

    public List<LineStringSegmentArrayProperty> getBreakLines() {
        if (breakLines == null)
            breakLines = new ChildList<>(this);

        return breakLines;
    }

    public void setBreakLines(List<LineStringSegmentArrayProperty> breakLines) {
        this.breakLines = asChild(breakLines);
    }

    public Length getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Length maxLength) {
        this.maxLength = asChild(maxLength);
    }

    public GeometricPositionList getControlPoints() {
        if (controlPoints == null)
            controlPoints = asChild(new GeometricPositionList());

        return controlPoints;
    }

    public void setControlPoints(GeometricPositionList controlPoints) {
        this.controlPoints = asChild(controlPoints);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = super.computeEnvelope();
        if (controlPoints != null) {
            List<Double> coordinates = controlPoints.toCoordinateList3D();
            for (int i = 0; i < coordinates.size(); i += 3)
                envelope.include(coordinates.subList(i, i + 3));
        }

        return envelope;
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
