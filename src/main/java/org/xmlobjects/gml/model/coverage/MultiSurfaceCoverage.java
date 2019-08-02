package org.xmlobjects.gml.model.coverage;

public class MultiSurfaceCoverage extends AbstractDiscreteCoverage<MultiSurfaceDomain> {

    public MultiSurfaceCoverage() {
    }

    public MultiSurfaceCoverage(MultiSurfaceDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiSurfaceCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }
}
