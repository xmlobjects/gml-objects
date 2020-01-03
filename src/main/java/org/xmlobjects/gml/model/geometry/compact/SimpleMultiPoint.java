package org.xmlobjects.gml.model.geometry.compact;

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.aggregates.AbstractMultiPoint;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.List;

public class SimpleMultiPoint extends AbstractMultiPoint {
    private DirectPositionList posList;

    public SimpleMultiPoint() {
    }

    public SimpleMultiPoint(DirectPositionList posList) {
        setPosList(posList);
    }

    public DirectPositionList getPosList() {
        return posList;
    }

    public void setPosList(DirectPositionList posList) {
        this.posList = asChild(posList);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (posList != null) {
            List<Double> coordinates = posList.toCoordinateList3D();
            for (int i = 0; i < coordinates.size(); i += 3)
                envelope.include(coordinates.subList(i, i + 3));
        }

        return envelope;
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
