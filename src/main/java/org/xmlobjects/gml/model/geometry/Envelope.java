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

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.model.Child;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Envelope extends GMLObject implements SRSReference, CoordinateListProvider {
    private DirectPosition lowerCorner;
    private DirectPosition upperCorner;
    private String srsName;
    private Integer srsDimension;
    private List<String> axisLabels;
    private List<String> uomLabels;

    public Envelope() {
        setLowerCorner(new DirectPosition());
        setUpperCorner(new DirectPosition());
    }

    public Envelope(DirectPosition lowerCorner, DirectPosition upperCorner) {
        setLowerCorner(lowerCorner != null ? lowerCorner : new DirectPosition());
        setUpperCorner(upperCorner != null ? upperCorner : new DirectPosition());
    }

    public DirectPosition getLowerCorner() {
        return lowerCorner;
    }

    public boolean isSetLowerCorner() {
        return !lowerCorner.getValue().isEmpty();
    }

    public void setLowerCorner(DirectPosition lowerCorner) {
        if (lowerCorner != null)
            this.lowerCorner = asChild(lowerCorner);
    }

    public DirectPosition getUpperCorner() {
        return upperCorner;
    }

    public boolean isSetUpperCorner() {
        return !upperCorner.getValue().isEmpty();
    }

    public void setUpperCorner(DirectPosition upperCorner) {
        if (upperCorner != null)
            this.upperCorner = asChild(upperCorner);
    }

    @Override
    public String getSrsName() {
        return srsName;
    }

    @Override
    public void setSrsName(String srsName) {
        this.srsName = srsName;
    }

    @Override
    public Integer getSrsDimension() {
        return srsDimension;
    }

    @Override
    public void setSrsDimension(Integer srsDimension) {
        if (srsDimension == null || srsDimension > 0)
            this.srsDimension = srsDimension;
    }

    @Override
    public List<String> getAxisLabels() {
        return axisLabels;
    }

    @Override
    public void setAxisLabels(List<String> axisLabels) {
        if (axisLabels == null)
            axisLabels = new ArrayList<>();

        this.axisLabels = axisLabels;
    }

    @Override
    public List<String> getUomLabels() {
        if (uomLabels == null)
            uomLabels = new ArrayList<>();

        return uomLabels;
    }

    @Override
    public void setUomLabels(List<String> uomLabels) {
        this.uomLabels = uomLabels;
    }

    public boolean isValid() {
        if (lowerCorner.getValue().isEmpty() || lowerCorner.getValue().size() != upperCorner.getValue().size())
            return false;

        for (int i = 0; i < lowerCorner.getValue().size(); i++) {
            if (lowerCorner.getValue().get(i) > upperCorner.getValue().get(i))
                return false;
        }

        return true;
    }

    public boolean isEmpty() {
        for (int i = 0; i < getDimension(); i++) {
            if (upperCorner.getValue().get(i) > lowerCorner.getValue().get(i))
                return false;
        }

        return true;
    }

    public int getDimension() {
        return isValid() ? lowerCorner.getValue().size() : 0;
    }

    public double getMinimum(int dimension) {
        if (dimension <= 0 || dimension > getDimension())
            throw new IndexOutOfBoundsException("Invalid dimension parameter.");

        return lowerCorner.getValue().get(dimension - 1);
    }

    public double getMaximum(int dimension) {
        if (dimension <= 0 || dimension > getDimension())
            throw new IndexOutOfBoundsException("Invalid dimension parameter.");

        return upperCorner.getValue().get(dimension - 1);
    }

    public double getMedian(int dimension) {
        if (dimension <= 0 || dimension > getDimension())
            throw new IndexOutOfBoundsException("Invalid dimension parameter.");

        return (lowerCorner.getValue().get(dimension - 1) + upperCorner.getValue().get(dimension - 1)) / 2;
    }

    public double getSpan(int dimension) {
        if (dimension <= 0 || dimension > getDimension())
            throw new IndexOutOfBoundsException("Invalid dimension parameter.");

        return upperCorner.getValue().get(dimension - 1) - lowerCorner.getValue().get(dimension - 1);
    }

    public DirectPosition getCenter() {
        DirectPosition center = null;
        if (isValid()) {
            center = new DirectPosition();
            for (int i = 0; i < lowerCorner.getValue().size(); i++)
                center.getValue().add((lowerCorner.getValue().get(i) + upperCorner.getValue().get(i)) / 2);
        }

        return center;
    }

    public boolean contains(double... ordinates) {
        return ordinates != null
                && contains(Arrays.stream(ordinates).boxed().collect(Collectors.toList()));
    }

    public boolean contains(List<Double> ordinates) {
        return ordinates != null
                && ordinates.size() == lowerCorner.getValue().size()
                && isValid()
                && contains(ordinates, ordinates);
    }

    public boolean contains(DirectPosition position) {
        return position != null
                && position.getValue().size() == lowerCorner.getValue().size()
                && isValid()
                && contains(position.getValue(), position.getValue());
    }

    public boolean contains(Envelope other) {
        return other != null
                && other.getDimension() == getDimension()
                && contains(other.lowerCorner.getValue(), other.upperCorner.getValue());
    }

    private boolean contains(List<Double> lowerCorner, List<Double> upperCorner) {
        for (int i = 0; i < lowerCorner.size(); i++) {
            if (lowerCorner.get(i) < this.lowerCorner.getValue().get(i)
                    || upperCorner.get(i) > this.upperCorner.getValue().get(i))
                return false;
        }

        return true;
    }

    public Envelope include(double... ordinates) {
        if (ordinates != null)
            include(Arrays.stream(ordinates).boxed().collect(Collectors.toList()));

        return this;
    }

    public Envelope include(List<Double> ordinates) {
        if (ordinates != null && !ordinates.isEmpty())
            include(ordinates, ordinates);

        return this;
    }

    public Envelope include(DirectPosition position) {
        if (position != null && !position.getValue().isEmpty())
            include(position.getValue(), position.getValue());

        return this;
    }

    public Envelope include(Envelope other) {
        if (other != null && other.isValid())
            include(other.lowerCorner.getValue(), other.upperCorner.getValue());

        return this;
    }

    private void include(List<Double> lowerCorner, List<Double> upperCorner) {
        if (!isValid()) {
            setLowerCorner(new DirectPosition(new ArrayList<>(lowerCorner)));
            setUpperCorner(new DirectPosition(new ArrayList<>(upperCorner)));
        } else {
            int dimension = getDimension();
            for (int i = 0; i < lowerCorner.size(); i++) {
                double minimum = lowerCorner.get(i);
                double maximum = upperCorner.get(i);

                if (i < dimension) {
                    if (minimum < this.lowerCorner.getValue().get(i))
                        this.lowerCorner.getValue().set(i, minimum);

                    if (maximum > this.upperCorner.getValue().get(i))
                        this.upperCorner.getValue().set(i, maximum);
                } else {
                    this.lowerCorner.getValue().add(minimum);
                    this.upperCorner.getValue().add(maximum);
                }
            }
        }
    }

    @Override
    public SRSReference getInheritedSRSReference() {
        if (srsName == null) {
            Child parent = this;
            while ((parent = parent.getParent()) != null) {
                if (parent instanceof AbstractFeature) {
                    AbstractFeature feature = (AbstractFeature) parent;
                    if (feature.getBoundedBy() != null
                            && feature.getBoundedBy().getEnvelope() != null
                            && feature.getBoundedBy().getEnvelope().getSrsName() != null)
                        return feature.getBoundedBy().getEnvelope();
                }
            }
        }

        return this;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        if (isValid()) {
            List<Double> coordinates = new ArrayList<>(6);
            coordinates.addAll(lowerCorner.toCoordinateList3D());
            coordinates.addAll(upperCorner.toCoordinateList3D());
            return coordinates;
        } else
            return Collections.emptyList();
    }
}
