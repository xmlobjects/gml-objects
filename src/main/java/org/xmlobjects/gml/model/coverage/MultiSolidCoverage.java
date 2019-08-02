package org.xmlobjects.gml.model.coverage;

public class MultiSolidCoverage extends AbstractDiscreteCoverage<MultiSolidDomain> {

    public MultiSolidCoverage() {
    }

    public MultiSolidCoverage(MultiSolidDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiSolidCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }
}
