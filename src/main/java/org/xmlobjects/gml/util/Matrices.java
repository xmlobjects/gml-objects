package org.xmlobjects.gml.util;

import Jama.Matrix;

import java.util.List;

public class Matrices {

    public static Matrix newMatrix(List<Double> values, int m) {
        double[] tmp = new double[values.size()];
        for (int i = 0; i < values.size(); i++)
            tmp[i] = values.get(i);

        return new Matrix(tmp, m);
    }
}
