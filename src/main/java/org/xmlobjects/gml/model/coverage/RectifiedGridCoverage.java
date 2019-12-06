package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.visitor.ObjectVisitor;

public class RectifiedGridCoverage extends AbstractDiscreteCoverage<RectifiedGridDomain> {

    public RectifiedGridCoverage() {
    }

    public RectifiedGridCoverage(RectifiedGridDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public RectifiedGridCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
