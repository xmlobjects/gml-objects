/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class TriangulatedSurface extends Surface {

    public TriangulatedSurface() {
    }

    public TriangulatedSurface(TriangleArrayProperty patches) {
        super(patches);
    }

    @Override
    public TriangleArrayProperty getPatches() {
        return (TriangleArrayProperty) super.getPatches();
    }

    @Override
    public void setPatches(SurfacePatchArrayProperty<?> patches) {
        if (patches instanceof TriangleArrayProperty property) {
            setPatches(property);
        } else {
            throw new IllegalArgumentException("Only a triangle array property is allowed.");
        }
    }

    public void setPatches(TriangleArrayProperty patches) {
        super.setPatches(patches);
    }

    @Override
    public void addPatch(AbstractSurfacePatch patch) {
        if (patch instanceof Triangle) {
            if (getPatches() == null)
                setPatches(new TriangleArrayProperty());

            super.addPatch(patch);
        }
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
