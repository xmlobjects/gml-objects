package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.visitor.FeatureVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class GridCoverage extends AbstractDiscreteCoverage<GridDomain> {

    public GridCoverage() {
    }

    public GridCoverage(GridDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public GridCoverage(CoverageFunction coverageFunction) {
        super(coverageFunction);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(FeatureVisitor visitor) {
        visitor.visit(this);
    }
}
