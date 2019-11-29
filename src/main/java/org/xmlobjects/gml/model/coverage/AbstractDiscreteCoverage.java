package org.xmlobjects.gml.model.coverage;

public abstract class AbstractDiscreteCoverage<T extends AbstractDomainSet<?>> extends AbstractCoverage<T> {
    private CoverageFunction coverageFunction;

    public AbstractDiscreteCoverage() {
    }

    public AbstractDiscreteCoverage(T domainSet, RangeSet rangeSet) {
        super(domainSet, rangeSet);
    }

    public AbstractDiscreteCoverage(CoverageFunction coverageFunction) {
        setCoverageFunction(coverageFunction);
    }

    public CoverageFunction getCoverageFunction() {
        return coverageFunction;
    }

    public void setCoverageFunction(CoverageFunction coverageFunction) {
        this.coverageFunction = asChild(coverageFunction);
    }
}
