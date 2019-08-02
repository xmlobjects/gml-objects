package org.xmlobjects.gml.model.coverage;

public abstract class AbstractContinuousCoverage<T extends AbstractDomainSet> extends AbstractCoverage<T> {
    private CoverageFunction coverageFunction;

    public AbstractContinuousCoverage() {
    }

    public AbstractContinuousCoverage(T domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public AbstractContinuousCoverage(CoverageFunction coverageFunction) {
        setCoverageFunction(coverageFunction);
    }

    public CoverageFunction getCoverageFunction() {
        return coverageFunction;
    }

    public void setCoverageFunction(CoverageFunction coverageFunction) {
        this.coverageFunction = asChild(coverageFunction);
    }
}
