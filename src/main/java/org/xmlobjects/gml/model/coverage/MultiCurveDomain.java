package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.model.geometry.aggregates.MultiCurve;

public class MultiCurveDomain extends AbstractDomainSet<MultiCurve> {

    public MultiCurveDomain() {
    }

    public MultiCurveDomain(MultiCurve object) {
        super(object);
    }

    public MultiCurveDomain(String href) {
        super(href);
    }

    @Override
    public Class<MultiCurve> getTargetType() {
        return MultiCurve.class;
    }
}
