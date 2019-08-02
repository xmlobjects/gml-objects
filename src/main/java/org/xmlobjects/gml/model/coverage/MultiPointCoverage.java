package org.xmlobjects.gml.model.coverage;

public class MultiPointCoverage extends AbstractDiscreteCoverage<MultiPointDomain> {

    public MultiPointCoverage() {
    }

    public MultiPointCoverage(MultiPointDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiPointCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }
}
