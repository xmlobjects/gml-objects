/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.model.geometry.grids;

import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.ArrayList;
import java.util.List;

public class Grid extends AbstractGeometry {
    private GridLimits limits;
    private List<String> gridAxisLabels;
    private Integer dimension;

    public Grid() {
    }

    public Grid(Integer dimension) {
        setDimension(dimension);
    }

    public GridLimits getLimits() {
        return limits;
    }

    public void setLimits(GridLimits limits) {
        this.limits = asChild(limits);
    }

    public List<String> getGridAxisLabels() {
        if (gridAxisLabels == null)
            gridAxisLabels = new ArrayList<>();

        return gridAxisLabels;
    }

    public boolean isSetGridAxisLabels() {
        return gridAxisLabels != null && !gridAxisLabels.isEmpty();
    }

    public void setGridAxisLabels(List<String> gridAxisLabels) {
        this.gridAxisLabels = gridAxisLabels;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        if (dimension != null && dimension > 0)
            this.dimension = dimension;
    }

    @Override
    public Envelope computeEnvelope() {
        return new Envelope();
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
