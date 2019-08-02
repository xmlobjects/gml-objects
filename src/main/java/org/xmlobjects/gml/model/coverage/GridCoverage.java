package org.xmlobjects.gml.model.coverage;

public class GridCoverage extends AbstractDiscreteCoverage<GridDomain> {

    public GridCoverage() {
    }

    public GridCoverage(GridDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public GridCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }
}
