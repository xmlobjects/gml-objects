/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2025 Claus Nagel <claus.nagel@gmail.com>
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
}
