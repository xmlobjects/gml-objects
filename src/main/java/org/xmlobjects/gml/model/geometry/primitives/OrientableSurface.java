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

import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class OrientableSurface extends AbstractSurface {
    private SurfaceProperty baseSurface;
    private Sign orientation;

    public OrientableSurface() {
    }

    public OrientableSurface(SurfaceProperty baseSurface) {
        setBaseSurface(baseSurface);
    }

    public OrientableSurface(AbstractSurface baseSurface) {
        this(new SurfaceProperty(baseSurface));
    }

    public SurfaceProperty getBaseSurface() {
        return baseSurface;
    }

    public void setBaseSurface(SurfaceProperty baseSurface) {
        this.baseSurface = asChild(baseSurface);
    }

    public Sign getOrientation() {
        return orientation != null ? orientation : Sign.PLUS;
    }

    public void setOrientation(Sign orientation) {
        this.orientation = orientation;
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (baseSurface != null && baseSurface.getObject() != null)
            envelope.include(baseSurface.getObject().computeEnvelope());

        return envelope;
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
