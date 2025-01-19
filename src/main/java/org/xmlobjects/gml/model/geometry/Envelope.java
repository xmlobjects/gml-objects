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

package org.xmlobjects.gml.model.geometry;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.model.Child;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        return lowerCorner.isSetValue();
    }

    public void setLowerCorner(DirectPosition lowerCorner) {
        if (lowerCorner != null)
            this.lowerCorner = asChild(lowerCorner);
    }

    public DirectPosition getUpperCorner() {
        return upperCorner;
    }

    public boolean isSetUpperCorner() {
        return upperCorner.isSetValue();
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
    public boolean isSetAxisLabels() {
        return axisLabels != null && !axisLabels.isEmpty();
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
    public boolean isSetUomLabels() {
        return uomLabels != null && !uomLabels.isEmpty();
    }

    @Override
    public void setUomLabels(List<String> uomLabels) {
        this.uomLabels = uomLabels;
    }

    public boolean isValid() {
        if (hasValidDimension()) {
            for (int i = 0; i < lowerCorner.getValue().size(); i++) {
                if (lowerCorner.getValue().get(i) > upperCorner.getValue().get(i))
                    return false;
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return !lowerCorner.isSetValue() && !upperCorner.isSetValue();
    }

    public int getDimension() {
        return hasValidDimension() ? lowerCorner.getValue().size() : 0;
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
        if (hasValidDimension()) {
            center = new DirectPosition();
            for (int i = 0; i < lowerCorner.getValue().size(); i++)
                center.getValue().add((lowerCorner.getValue().get(i) + upperCorner.getValue().get(i)) / 2);
        }

        return center;
    }

    public boolean contains(double... ordinates) {
        return ordinates != null && contains(Arrays.stream(ordinates).boxed().toList());
    }

    public boolean contains(DirectPosition position) {
        return position != null && contains(position.getValue());
    }

    public boolean contains(Envelope other) {
        return other != null
                && other.hasValidDimension()
                && contains(other.lowerCorner.getValue())
                && contains(other.upperCorner.getValue());
    }

    public boolean contains(List<Double> ordinates) {
        if (ordinates != null && hasValidDimension()) {
            int dimension = Math.min(ordinates.size(), lowerCorner.getValue().size());
            for (int i = 0; i < dimension; i++) {
                if (ordinates.get(i) < lowerCorner.getValue().get(i)
                        || ordinates.get(i) > upperCorner.getValue().get(i)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public boolean intersects(Envelope other) {
        if (other != null
                && hasValidDimension()
                && other.hasValidDimension()) {
            int dimension = Math.min(other.lowerCorner.getValue().size(), lowerCorner.getValue().size());
            for (int i = 0; i < dimension; i++) {
                if (other.lowerCorner.getValue().get(i) > upperCorner.getValue().get(i)
                        || other.upperCorner.getValue().get(i) < lowerCorner.getValue().get(i)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public Envelope include(double... ordinates) {
        if (ordinates != null)
            include(Arrays.stream(ordinates).boxed().toList());

        return this;
    }

    public Envelope include(DirectPosition position) {
        if (position != null)
            include(position.getValue());

        return this;
    }

    public Envelope include(Envelope other) {
        if (other != null && other.hasValidDimension()) {
            include(other.lowerCorner.getValue());
            include(other.upperCorner.getValue());
        }

        return this;
    }

    public Envelope include(List<Double> ordinates) {
        if (ordinates != null && !ordinates.isEmpty()) {
            int dimension = Math.min(lowerCorner.getValue().size(), upperCorner.getValue().size());
            for (int i = 0; i < ordinates.size(); i++) {
                double ordinate = ordinates.get(i);
                if (i < dimension) {
                    if (ordinate < lowerCorner.getValue().get(i)) {
                        lowerCorner.getValue().set(i, ordinate);
                    }

                    if (ordinate > upperCorner.getValue().get(i)) {
                        upperCorner.getValue().set(i, ordinate);
                    }
                } else {
                    if (dimension > 0) {
                        lowerCorner.setValue(lowerCorner.getValue().subList(0, i));
                        upperCorner.setValue(upperCorner.getValue().subList(0, i));
                    }

                    lowerCorner.getValue().add(ordinate);
                    upperCorner.getValue().add(ordinate);
                }
            }
        }

        return this;
    }

    @Override
    public SRSReference getInheritedSRSReference() {
        if (srsName == null) {
            Child parent = this;
            while ((parent = parent.getParent()) != null) {
                if (parent instanceof AbstractFeature feature) {
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
        if (!isEmpty()) {
            List<Double> coordinates = new ArrayList<>(6);
            coordinates.addAll(lowerCorner.toCoordinateList3D());
            coordinates.addAll(upperCorner.toCoordinateList3D());
            return coordinates;
        } else
            return Collections.emptyList();
    }

    private boolean hasValidDimension() {
        return !isEmpty() && lowerCorner.getValue().size() == upperCorner.getValue().size();
    }
}
