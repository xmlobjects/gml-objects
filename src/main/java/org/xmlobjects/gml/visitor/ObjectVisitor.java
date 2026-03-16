/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
