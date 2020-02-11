/*
 * gml-objects - A Java XML binding for the OGC Geography Markup Language (GML)
 * https://github.com/xmlobjects/gml-objects
 *
 * Copyright 2019-2020 Claus Nagel <claus.nagel@gmail.com>
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
        if (!(patches instanceof TriangleArrayProperty))
            throw new IllegalArgumentException("Only a triangle array property is allowed.");

        setPatches((TriangleArrayProperty) patches);
    }

    public void setPatches(TriangleArrayProperty patches) {
        super.setPatches(patches);
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
