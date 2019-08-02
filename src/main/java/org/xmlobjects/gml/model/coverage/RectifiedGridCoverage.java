package org.xmlobjects.gml.model.coverage;

public class RectifiedGridCoverage extends AbstractDiscreteCoverage<RectifiedGridDomain> {

    public RectifiedGridCoverage() {
    }

    public RectifiedGridCoverage(RectifiedGridDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public RectifiedGridCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }
}
