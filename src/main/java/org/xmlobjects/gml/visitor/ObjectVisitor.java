package org.xmlobjects.gml.visitor;

import org.xmlobjects.gml.model.coverage.GridCoverage;
import org.xmlobjects.gml.model.coverage.MultiCurveCoverage;
import org.xmlobjects.gml.model.coverage.MultiPointCoverage;
import org.xmlobjects.gml.model.coverage.MultiSolidCoverage;
import org.xmlobjects.gml.model.coverage.MultiSurfaceCoverage;
import org.xmlobjects.gml.model.coverage.RectifiedGridCoverage;
import org.xmlobjects.gml.model.temporal.TimeInstant;
import org.xmlobjects.gml.model.temporal.TimePeriod;
import org.xmlobjects.gml.model.valueobjects.CompositeValue;
import org.xmlobjects.gml.model.valueobjects.ValueArray;

public interface ObjectVisitor extends GeometryVisitor {
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
