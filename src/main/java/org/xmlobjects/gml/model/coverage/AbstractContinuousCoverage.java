/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2021 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xmlobjects.gml.model.coverage;

public abstract class AbstractContinuousCoverage<T extends AbstractDomainSet<?>> extends AbstractCoverage<T> {
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
