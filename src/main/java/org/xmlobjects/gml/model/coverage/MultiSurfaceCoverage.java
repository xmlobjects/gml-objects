package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.visitor.FeatureVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class MultiSurfaceCoverage extends AbstractDiscreteCoverage<MultiSurfaceDomain> {

    public MultiSurfaceCoverage() {
    }

    public MultiSurfaceCoverage(MultiSurfaceDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiSurfaceCoverage(CoverageFunction coverageFunction) {
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
