package org.xmlobjects.gml.model.coverage;

import org.xmlobjects.gml.visitor.FeatureVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class MultiSolidCoverage extends AbstractDiscreteCoverage<MultiSolidDomain> {

    public MultiSolidCoverage() {
    }

    public MultiSolidCoverage(MultiSolidDomain domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public MultiSolidCoverage(CoverageFunction coverageFunction) {
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
