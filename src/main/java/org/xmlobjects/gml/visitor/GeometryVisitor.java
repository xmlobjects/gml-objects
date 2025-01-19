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
