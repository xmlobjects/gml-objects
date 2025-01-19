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

package org.xmlobjects.gml.model.common;

import java.util.List;

public interface CoordinateListProvider {
    List<Double> toCoordinateList3D();

    default List<Double> toCoordinateList3D(boolean reverse) {
        return !reverse ? toCoordinateList3D() : reversedCoordinateList(this);
    }

    static List<Double> reversedCoordinateList(CoordinateListProvider provider) {
        List<Double> coordinates = provider.toCoordinateList3D();
        if (coordinates.size() % 3 != 0)
            throw new IllegalArgumentException("The size of the coordinate list must be a multiple of 3.");

        for (int i = coordinates.size() - 3, j = 0; j < coordinates.size() / 2; i -= 3, j += 3) {
            double x = coordinates.get(j);
            double y = coordinates.get(j + 1);
            double z = coordinates.get(j + 2);

            coordinates.set(j, coordinates.get(i));
            coordinates.set(j + 1, coordinates.get(i + 1));
            coordinates.set(j + 2, coordinates.get(i + 2));

            coordinates.set(i, x);
            coordinates.set(i + 1, y);
            coordinates.set(i + 2, z);
        }

        return coordinates;
    }
}
