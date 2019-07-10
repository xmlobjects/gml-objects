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
            throw new IllegalArgumentException("The size of the posList must be a multiple of 3.");

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
