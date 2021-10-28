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
        if (!(patches instanceof PolygonPatchArrayProperty))
            throw new IllegalArgumentException("Only a polygon patch array property is allowed.");

        setPatches((PolygonPatchArrayProperty) patches);
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
