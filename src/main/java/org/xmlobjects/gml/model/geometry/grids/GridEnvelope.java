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

package org.xmlobjects.gml.model.geometry.grids;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GridEnvelope extends GMLObject {
    private List<Integer> low;
    private List<Integer> high;

    public GridEnvelope() {
    }

    public GridEnvelope(List<Integer> low, List<Integer> high) {
        this.low = low;
        this.high = high;
    }

    public List<Integer> getLow() {
        if (low == null)
            low = new ArrayList<>();

        return low;
    }

    public void setLow(List<Integer> low) {
        this.low = low;
    }

    public List<Integer> getHigh() {
        if (high == null)
            high = new ArrayList<>();

        return high;
    }

    public void setHigh(List<Integer> high) {
        this.high = high;
    }

    public Envelope toEnvelope() {
        Envelope envelope = new Envelope();
        if (low != null && high != null && !low.isEmpty() && low.size() == high.size()) {
            envelope.include(low.stream().map(Double::valueOf).collect(Collectors.toList()));
            envelope.include(high.stream().map(Double::valueOf).collect(Collectors.toList()));
        }

        return envelope;
    }
}
