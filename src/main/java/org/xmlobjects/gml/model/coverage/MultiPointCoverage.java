package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.visitor.ObjectVisitor;

public class MultiPointCoverage extends AbstractDiscreteCoverage<MultiPointDomain> {

    public MultiPointCoverage() {
    }

    public MultiPointCoverage(MultiPointDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiPointCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
