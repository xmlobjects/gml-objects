package org.xmlobjects.gml.model.coverage;

public class MultiCurveCoverage extends AbstractDiscreteCoverage<MultiCurveDomain> {

    public MultiCurveCoverage() {
    }

    public MultiCurveCoverage(MultiCurveDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiCurveCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }
}
