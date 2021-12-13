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

package org.xmlobjects.gml.visitor;

import org.xmlobjects.gml.model.base.*;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;
import org.xmlobjects.gml.model.geometry.AbstractInlineGeometryProperty;
import org.xmlobjects.gml.model.geometry.GeometryArrayProperty;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.*;
import org.xmlobjects.gml.model.geometry.compact.*;
import org.xmlobjects.gml.model.geometry.complexes.CompositeCurve;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSolid;
import org.xmlobjects.gml.model.geometry.complexes.CompositeSurface;
import org.xmlobjects.gml.model.geometry.complexes.GeometricComplex;
import org.xmlobjects.gml.model.geometry.grids.Grid;
import org.xmlobjects.gml.model.geometry.grids.RectifiedGrid;
import org.xmlobjects.gml.model.geometry.primitives.*;

import java.util.ArrayList;

public abstract class GeometryWalker implements GeometryVisitor {
    protected boolean shouldWalk = true;

    public boolean shouldWalk() {
        return shouldWalk;
    }

    public void setShouldWalk(boolean shouldWalk) {
        this.shouldWalk = shouldWalk;
    }

    public void reset() {
        shouldWalk = true;
    }

    public void visit(AbstractGeometry geometry) {
    }

    public void visit(AbstractGeometricAggregate geometricAggregate) {
        visit((AbstractGeometry) geometricAggregate);
    }

    public void visit(AbstractGeometricPrimitive geometricPrimitive) {
        visit((AbstractGeometry) geometricPrimitive);
    }

    public void visit(AbstractMultiPoint multiPoint) {
        visit((AbstractGeometricAggregate) multiPoint);
    }

    public void visit(AbstractCurve curve) {
        visit((AbstractGeometricPrimitive) curve);
    }

    public void visit(AbstractSolid solid) {
        visit((AbstractGeometricPrimitive) solid);
    }

    public void visit(AbstractSurface surface) {
        visit((AbstractGeometricPrimitive) surface);
    }

    public void visit(AbstractRing ring) {
        visit((AbstractCurve) ring);
    }

    public void visit(AbstractSimplePolygon simplePolygon) {
        visit((AbstractSurface) simplePolygon);
    }

    public void visit(AbstractSurfacePatch surfacePatch) {
    }

    @Override
    public void visit(CompositeCurve compositeCurve) {
        visit((AbstractCurve) compositeCurve);

        for (CurveProperty property : new ArrayList<>(compositeCurve.getCurveMembers()))
            visit(property);
    }

    @Override
    public void visit(CompositeSolid compositeSolid) {
        visit((AbstractSolid) compositeSolid);

        for (SolidProperty property : new ArrayList<>(compositeSolid.getSolidMembers()))
            visit(property);
    }

    @Override
    public void visit(CompositeSurface compositeSurface) {
        visit((AbstractSurface) compositeSurface);

        for (SurfaceProperty property : new ArrayList<>(compositeSurface.getSurfaceMembers()))
            visit(property);
    }

    @Override
    public void visit(Curve curve) {
        visit((AbstractCurve) curve);
    }

    @Override
    public void visit(GeometricComplex geometricComplex) {
        visit((AbstractGeometry) geometricComplex);

        for (GeometricPrimitiveProperty property : new ArrayList<>(geometricComplex.getElements()))
            visit(property);
    }

    @Override
    public void visit(Grid grid) {
        visit((AbstractGeometry) grid);
    }

    @Override
    public void visit(LinearRing linearRing) {
        visit((AbstractRing) linearRing);
    }

    @Override
    public void visit(LineString lineString) {
        visit((AbstractCurve) lineString);
    }

    @Override
    public void visit(MultiCurve multiCurve) {
        visit((AbstractGeometricAggregate) multiCurve);

        for (CurveProperty property : new ArrayList<>(multiCurve.getCurveMember()))
            visit(property);

        visit(multiCurve.getCurveMembers());
    }

    @Override
    public void visit(MultiGeometry multiGeometry) {
        visit((AbstractGeometricAggregate) multiGeometry);

        for (GeometryProperty<?> property : new ArrayList<>(multiGeometry.getGeometryMember()))
            visit(property);

        visit(multiGeometry.getGeometryMembers());
    }

    @Override
    public void visit(MultiPoint multiPoint) {
        visit((AbstractMultiPoint) multiPoint);

        for (PointProperty property : new ArrayList<>(multiPoint.getPointMember()))
            visit(property);

        visit(multiPoint.getPointMembers());
    }

    @Override
    public void visit(MultiSolid multiSolid) {
        visit((AbstractGeometricAggregate) multiSolid);

        for (SolidProperty property : new ArrayList<>(multiSolid.getSolidMember()))
            visit(property);

        visit(multiSolid.getSolidMembers());
    }

    @Override
    public void visit(MultiSurface multiSurface) {
        visit((AbstractGeometricAggregate) multiSurface);

        for (SurfaceProperty property : new ArrayList<>(multiSurface.getSurfaceMember()))
            visit(property);

        visit(multiSurface.getSurfaceMembers());
    }

    @Override
    public void visit(OrientableCurve orientableCurve) {
        visit((AbstractCurve) orientableCurve);

        visit(orientableCurve.getBaseCurve());
    }

    @Override
    public void visit(OrientableSurface orientableSurface) {
        visit((AbstractSurface) orientableSurface);

        visit(orientableSurface.getBaseSurface());
    }

    @Override
    public void visit(Point point) {
        visit((AbstractGeometricPrimitive) point);
    }

    @Override
    public void visit(Polygon polygon) {
        visit((AbstractSurface) polygon);

        visit(polygon.getExterior());

        for (AbstractRingProperty property : new ArrayList<>(polygon.getInterior()))
            visit(property);
    }

    @Override
    public void visit(PolygonPatch polygonPatch) {
        visit((AbstractSurfacePatch) polygonPatch);

        visit(polygonPatch.getExterior());

        for (AbstractRingProperty property : new ArrayList<>(polygonPatch.getInterior()))
            visit(property);
    }

    @Override
    public void visit(PolyhedralSurface polyhedralSurface) {
        visit((Surface) polyhedralSurface);
    }

    @Override
    public void visit(Rectangle rectangle) {
        visit((AbstractSurfacePatch) rectangle);

        visit(rectangle.getExterior());
    }

    @Override
    public void visit(RectifiedGrid rectifiedGrid) {
        visit((Grid) rectifiedGrid);

        visit(rectifiedGrid.getOrigin());
    }

    @Override
    public void visit(Ring ring) {
        visit((AbstractRing) ring);

        for (CurveProperty property : new ArrayList<>(ring.getCurveMembers()))
            visit(property);
    }

    @Override
    public void visit(Shell shell) {
        visit((AbstractSurface) shell);

        for (SurfaceProperty property : new ArrayList<>(shell.getSurfaceMembers()))
            visit(property);
    }

    @Override
    public void visit(SimpleMultiPoint simpleMultiPoint) {
        visit((AbstractMultiPoint) simpleMultiPoint);
    }

    @Override
    public void visit(SimplePolygon simplePolygon) {
        visit((AbstractSimplePolygon) simplePolygon);
    }

    @Override
    public void visit(SimpleRectangle simpleRectangle) {
        visit((AbstractSimplePolygon) simpleRectangle);
    }

    @Override
    public void visit(SimpleTriangle simpleTriangle) {
        visit((AbstractSimplePolygon) simpleTriangle);
    }

    @Override
    public void visit(Solid solid) {
        visit((AbstractSolid) solid);

        visit(solid.getExterior());

        for (ShellProperty property : new ArrayList<>(solid.getInterior()))
            visit(property);
    }

    @Override
    public void visit(Surface surface) {
        visit((AbstractSurface) surface);

        visit(surface.getPatches());
    }

    @Override
    public void visit(Tin tin) {
        visit((TriangulatedSurface) tin);
    }

    @Override
    public void visit(Triangle triangle) {
        visit((AbstractSurfacePatch) triangle);

        visit(triangle.getExterior());
    }

    @Override
    public void visit(TriangulatedSurface triangulatedSurface) {
        visit((Surface) triangulatedSurface);
    }

    public void visit(AbstractAssociation<?> association) {
    }

    public void visit(AbstractArrayProperty<?> property) {
        visit((AbstractAssociation<?>) property);

        if (property != null) {
            for (Object object : new ArrayList<>(property.getObjects())) {
                if (shouldWalk && object != null)
                    visitObject(object);
            }
        }
    }

    public void visit(AbstractInlineOrByReferenceProperty<?> property) {
        visit((AbstractAssociation<?>) property);

        if (shouldWalk && property != null && property.isSetObject())
            visitObject(property.getObject());
    }

    public void visit(AbstractProperty<?> property) {
        visit((AbstractInlineOrByReferenceProperty<?>) property);
    }

    public void visit(AbstractInlineProperty<?> property) {
        visit((AbstractAssociation<?>) property);

        if (shouldWalk && property != null && property.getObject() != null)
            visitObject(property.getObject());
    }

    public void visit(AbstractReference<?> reference) {
        visit((AbstractAssociation<?>) reference);
    }

    public void visit(GeometryProperty<?> property) {
        visit((AbstractProperty<?>) property);
    }

    public void visit(AbstractInlineGeometryProperty<?> property) {
        visit((AbstractInlineProperty<?>) property);
    }

    public void visit(GeometryArrayProperty<?> property) {
        visit((AbstractArrayProperty<?>) property);
    }

    public void visit(SurfacePatchArrayProperty<?> property) {
        visit((AbstractArrayProperty<?>) property);
    }

    protected void visitObject(Object object) {
        if (object instanceof AbstractGeometry)
            ((AbstractGeometry) object).accept(this);
        else if (object instanceof AbstractSurfacePatch)
            ((AbstractSurfacePatch) object).accept(this);
    }
}
