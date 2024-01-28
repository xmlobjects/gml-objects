/*
 * gml-objects - A Java mapping for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.xmlobjects.gml.visitor;

import org.xmlobjects.gml.model.coverage.*;
import org.xmlobjects.gml.model.deprecated.DefinitionProxy;
import org.xmlobjects.gml.model.dictionary.Definition;
import org.xmlobjects.gml.model.dictionary.Dictionary;
import org.xmlobjects.gml.model.temporal.TimeInstant;
import org.xmlobjects.gml.model.temporal.TimePeriod;
import org.xmlobjects.gml.model.valueobjects.CompositeValue;
import org.xmlobjects.gml.model.valueobjects.ValueArray;

public interface ObjectVisitor extends GeometryVisitor {
    void visit(Definition definition);
    void visit(DefinitionProxy definitionProxy);
    void visit(Dictionary dictionary);
    void visit(GridCoverage gridCoverage);
    void visit(MultiCurveCoverage multiCurveCoverage);
    void visit(MultiPointCoverage multiPointCoverage);
    void visit(MultiSolidCoverage multiSolidCoverage);
    void visit(MultiSurfaceCoverage multiSurfaceCoverage);
    void visit(RectifiedGridCoverage rectifiedGridCoverage);
    void visit(CompositeValue compositeValue);
    void visit(TimeInstant timeInstant);
    void visit(TimePeriod timePeriod);
    void visit(ValueArray valueArray);
}
