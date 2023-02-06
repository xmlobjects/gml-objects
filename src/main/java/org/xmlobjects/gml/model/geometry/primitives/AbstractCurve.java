/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2023 Claus Nagel <claus.nagel@gmail.com>
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

import org.xmlobjects.gml.model.common.CoordinateListProvider;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.util.List;

public abstract class AbstractCurve extends AbstractGeometricPrimitive implements CoordinateListProvider {

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        List<Double> coordinates = toCoordinateList3D();
        for (int i = 0; i < coordinates.size(); i += 3)
            envelope.include(coordinates.subList(i, i + 3));

        return envelope;
    }
}
