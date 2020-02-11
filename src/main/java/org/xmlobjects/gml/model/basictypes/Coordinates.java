/*
 * gml-objects - A Java XML binding for the OGC Geography Markup Language (GML)
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

package org.xmlobjects.gml.model.basictypes;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.DirectPosition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Coordinates extends GMLObject implements CoordinateListProvider {
    public static final String DEFAULT_DECIMAL = ".";
    public static final String DEFAULT_COORDINATE_SEPARATOR = ",";
    public static final String DEFAULT_TUPLE_SEPARATOR = " ";

    private String value;
    private String decimal;
    private String cs;
    private String ts;

    public Coordinates() {
    }

    public Coordinates(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value != null ? value.trim().replaceAll("\\R+", getTupleSeparator()) : null;
    }

    public String getDecimal() {
        return decimal != null ? decimal : DEFAULT_DECIMAL;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public String getCoordinateSeparator() {
        return cs != null ? cs : DEFAULT_COORDINATE_SEPARATOR;
    }

    public void setCoordinateSeparator(String cs) {
        this.cs = cs;
    }

    public String getTupleSeparator() {
        return ts != null ? ts : DEFAULT_TUPLE_SEPARATOR;
    }

    public void setTupleSeparator(String ts) {
        this.ts = ts;
    }

    public DirectPosition toDirectPosition() {
        List<List<Double>> coordinates = toCoordinateList(false);
        return new DirectPosition(!coordinates.isEmpty() ? coordinates.get(0) : new ArrayList<>());
    }

    public List<DirectPosition> toDirectPositions() {
        List<List<Double>> coordinates = toCoordinateList(false);
        List<DirectPosition> positions = new ArrayList<>(coordinates.size());
        coordinates.stream().map(DirectPosition::new).forEach(positions::add);
        return positions;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        List<List<Double>> coordinates = toCoordinateList(true);
        List<Double> flatList = new ArrayList<>(coordinates.size() * 3);
        coordinates.forEach(flatList::addAll);
        return flatList;
    }

    private List<List<Double>> toCoordinateList(boolean force3D) {
        List<List<Double>> coordinates = null;
        boolean isValid = true;

        if (value != null) {
            String decimalPattern = Pattern.quote(getDecimal()) + "+";
            String csPattern = Pattern.quote(getCoordinateSeparator()) + "+";
            String tsPattern = Pattern.quote(getTupleSeparator()) + "+";

            String[] tuples = value.split(tsPattern);
            coordinates = new ArrayList<>(tuples.length);

            for (int i = 0; i < tuples.length && isValid; i++) {
                String[] coords = tuples[i].split(csPattern);
                int size = force3D ? 3 : coords.length;
                List<Double> pos = new ArrayList<>(size);

                for (int j = 0; j < size && isValid; j++) {
                    if (j < coords.length) {
                        try {
                            pos.add(Double.parseDouble(coords[j].replaceAll(decimalPattern, ".")));
                        } catch (Throwable e) {
                            isValid = false;
                        }
                    } else
                        pos.add(0d);
                }

                coordinates.add(pos);
            }
        }

        return coordinates != null && isValid ? coordinates : Collections.emptyList();
    }
}
