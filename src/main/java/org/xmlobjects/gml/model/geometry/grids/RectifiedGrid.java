package org.xmlobjects.gml.model.geometry.grids;

import Jama.Matrix;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.Vector;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.gml.util.Matrices;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class RectifiedGrid extends Grid {
    private PointProperty origin;
    private List<Vector> offsetVectors;

    public PointProperty getOrigin() {
        return origin;
    }

    public void setOrigin(PointProperty origin) {
        this.origin = asChild(origin);
    }

    public List<Vector> getOffsetVectors() {
        if (offsetVectors == null)
            offsetVectors = new ChildList<>(this);

        return offsetVectors;
    }

    public void setOffsetVectors(List<Vector> offsetVectors) {
        this.offsetVectors = asChild(offsetVectors);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();

        if (origin != null && origin.getObject() != null && offsetVectors != null) {
            Envelope gridEnvelope = getLimits() != null && getLimits().getGridEnvelope() != null ?
                    getLimits().getGridEnvelope().toEnvelope() :
                    new Envelope();
            int dimension = gridEnvelope.getDimension();

            if (dimension > 0 && offsetVectors.size() >= dimension) {
                Matrix[] offsetVectors = new Matrix[3];
                offsetVectors[0] = Matrices.newMatrix(this.offsetVectors.get(0).toCoordinateList3D(), 3);
                offsetVectors[1] = dimension >= 2 ? Matrices.newMatrix(this.offsetVectors.get(1).toCoordinateList3D(), 3) : new Matrix(3, 1, 0);
                offsetVectors[2] = dimension >= 3 ? Matrices.newMatrix(this.offsetVectors.get(2).toCoordinateList3D(), 3) : new Matrix(3, 1, 0);

                Matrix origin = Matrices.newMatrix(this.origin.getObject().toCoordinateList3D(), 3);
                List<Double> limits = gridEnvelope.toCoordinateList3D();

                double[] lowerCorner = origin
                        .plus(offsetVectors[0].times(limits.get(0)))
                        .plus(offsetVectors[1].times(limits.get(1)))
                        .plus(offsetVectors[2].times(limits.get(2))).getColumnPackedCopy();

                double[] upperCorner = origin
                        .plus(offsetVectors[0].times(limits.get(3)))
                        .plus(offsetVectors[1].times(limits.get(4)))
                        .plus(offsetVectors[2].times(limits.get(5))).getColumnPackedCopy();

                envelope.include(lowerCorner)
                        .include(upperCorner);
            }
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
