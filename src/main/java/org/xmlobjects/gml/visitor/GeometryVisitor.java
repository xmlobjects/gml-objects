/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.visitor;

import org.xmlobjects.gml.model.geometry.aggregates.*;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;
import org.xmlobjects.gml.model.geometry.compact.SimplePolygon;
import org.xmlobjects.gml.model.geometry.compact.SimpleRectangle;
import org.xmlobjects.gml.model.geometry.compact.SimpleTriangle;
import org.xmlobjects.gml.model.geometry.complexes.CompositeCurve;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplex;
import org.xmlobjects.gml.model.geometry.grids.Grid;
import org.xmlobjects.gml.model.geometry.grids.RectifiedGrid;
import org.xmlobjects.gml.model.geometry.primitives.*;

public interface GeometryVisitor {
    void visit(CompositeCurve compositeCurve);

    void visit(CompositeSolid compositeSolid);

    void visit(CompositeSurface compositeSurface);

    void visit(Curve curve);

    void visit(GeometricComplex geometricComplex);

    void visit(Grid grid);

    void visit(LinearRing linearRing);

    void visit(LineString lineString);

    void visit(MultiCurve multiCurve);

    void visit(MultiGeometry multiGeometry);

    void visit(MultiPoint multiPoint);

    void visit(MultiSolid multiSolid);

    void visit(MultiSurface multiSurface);

    void visit(OrientableCurve orientableCurve);

    void visit(OrientableSurface orientableSurface);

    void visit(Point point);

    void visit(Polygon polygon);

    void visit(PolygonPatch polygonPatch);

    void visit(PolyhedralSurface polyhedralSurface);

    void visit(Rectangle rectangle);

    void visit(RectifiedGrid rectifiedGrid);

    void visit(Ring ring);

    void visit(Shell shell);

    void visit(SimpleMultiPoint simpleMultiPoint);

    void visit(SimplePolygon simplePolygon);

    void visit(SimpleRectangle simpleRectangle);

    void visit(SimpleTriangle simpleTriangle);

    void visit(Solid solid);

    void visit(Surface surface);

    void visit(Tin tin);

    void visit(Triangle triangle);

    void visit(TriangulatedSurface triangulatedSurface);
}
