package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.basicTypes.Sign;

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
}
