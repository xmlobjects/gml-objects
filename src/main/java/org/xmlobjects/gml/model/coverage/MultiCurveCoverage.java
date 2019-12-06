package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.visitor.ObjectVisitor;

public class MultiCurveCoverage extends AbstractDiscreteCoverage<MultiCurveDomain> {

    public MultiCurveCoverage() {
    }

    public MultiCurveCoverage(MultiCurveDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiCurveCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
