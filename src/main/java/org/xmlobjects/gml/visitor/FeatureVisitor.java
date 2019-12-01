package org.xmlobjects.gml.visitor;

import org.xmlobjects.gml.model.coverage.GridCoverage;
import org.xmlobjects.gml.model.coverage.MultiCurveCoverage;
import org.xmlobjects.gml.model.coverage.MultiPointCoverage;
import org.xmlobjects.gml.model.coverage.MultiSolidCoverage;
import org.xmlobjects.gml.model.coverage.MultiSurfaceCoverage;
import org.xmlobjects.gml.model.coverage.RectifiedGridCoverage;

public interface FeatureVisitor {
    void visit(GridCoverage gridCoverage);
    void visit(MultiCurveCoverage multiCurveCoverage);
    void visit(MultiPointCoverage multiPointCoverage);
    void visit(MultiSolidCoverage multiSolidCoverage);
    void visit(MultiSurfaceCoverage multiSurfaceCoverage);
    void visit(RectifiedGridCoverage rectifiedGridCoverage);
}
