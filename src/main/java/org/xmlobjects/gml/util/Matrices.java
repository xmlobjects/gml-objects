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

package org.xmlobjects.gml.util;

import Jama.Matrix;
import org.xmlobjects.gml.model.common.CoordinateListProvider;

import java.util.List;

public class Matrices {

    public static Matrix newMatrix(List<Double> values, int m) {
        double[] tmp = new double[values.size()];
        for (int i = 0; i < values.size(); i++)
            tmp[i] = values.get(i);

        return new Matrix(tmp, m);
    }

    public static List<Double> transform3D(CoordinateListProvider provider, Matrix matrix) {
        if ((matrix.getRowDimension() != 3 && matrix.getRowDimension() != 4) || matrix.getColumnDimension() != 4)
            throw new IllegalArgumentException("A 3D transformation requires either a 3x4 or a 4x4 matrix.");

        List<Double> coordinates = provider.toCoordinateList3D();
        for (int i = 0; i < coordinates.size(); i +=3) {
            Matrix v = new Matrix(new double[]{coordinates.get(i), coordinates.get(i + 1), coordinates.get(i + 2), 1}, 4);
            v = matrix.times(v);

            coordinates.set(i, v.get(0, 0));
            coordinates.set(i + 1, v.get(1, 0));
            coordinates.set(i + 2, v.get(2, 0));
        }

        return coordinates;
    }
}
