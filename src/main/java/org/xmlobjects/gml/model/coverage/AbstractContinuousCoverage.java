package org.xmlobjects.gml.model.coverage;

public abstract class AbstractContinuousCoverage<T extends AbstractDomainSet> extends AbstractCoverage<T> {
    private CoverageFunction coverageFunction;

    AbstractContinuousCoverage() {
    }

    AbstractContinuousCoverage(T domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    AbstractContinuousCoverage(CoverageFunction coverageFunction) {
        setCoverageFunction(coverageFunction);
    }

    public CoverageFunction getCoverageFunction() {
        return coverageFunction;
    }

    public void setCoverageFunction(CoverageFunction coverageFunction) {
        this.coverageFunction = asChild(coverageFunction);
    }
}
