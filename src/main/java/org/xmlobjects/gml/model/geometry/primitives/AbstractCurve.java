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
