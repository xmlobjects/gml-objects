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
