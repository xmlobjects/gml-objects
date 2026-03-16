/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class PolyhedralSurface extends Surface {

    public PolyhedralSurface() {
    }

    public PolyhedralSurface(PolygonPatchArrayProperty patches) {
        super(patches);
    }

    @Override
    public PolygonPatchArrayProperty getPatches() {
        return (PolygonPatchArrayProperty) super.getPatches();
    }

    @Override
    public void setPatches(SurfacePatchArrayProperty<?> patches) {
        if (patches instanceof PolygonPatchArrayProperty property) {
            setPatches(property);
        } else {
            throw new IllegalArgumentException("Only a polygon patch array property is allowed.");
        }
    }

    public void setPatches(PolygonPatchArrayProperty patches) {
        super.setPatches(patches);
    }

    @Override
    public void addPatch(AbstractSurfacePatch patch) {
        if (patch instanceof PolygonPatch) {
            if (getPatches() == null)
                setPatches(new PolygonPatchArrayProperty());

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
