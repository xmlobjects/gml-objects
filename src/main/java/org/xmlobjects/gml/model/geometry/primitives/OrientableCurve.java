package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

import java.util.Collections;
import java.util.List;

public class OrientableCurve extends AbstractCurve {
    private CurveProperty baseCurve;
    private Sign orientation;

    public OrientableCurve() {
    }

    public OrientableCurve(CurveProperty baseCurve) {
        setBaseCurve(baseCurve);
    }

    public OrientableCurve(AbstractCurve baseCurve) {
        this(new CurveProperty(baseCurve));
    }

    public CurveProperty getBaseCurve() {
        return baseCurve;
    }

    public void setBaseCurve(CurveProperty baseCurve) {
        this.baseCurve = asChild(baseCurve);
    }

    public Sign getOrientation() {
        return orientation != null ? orientation : Sign.PLUS;
    }

    public void setOrientation(Sign orientation) {
        this.orientation = orientation;
    }

    @Override
    public List<Double> toCoordinateList3D() {
        return baseCurve != null && baseCurve.getObject() != null ?
                baseCurve.getObject().toCoordinateList3D(getOrientation() == Sign.MINUS) :
                Collections.emptyList();
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
