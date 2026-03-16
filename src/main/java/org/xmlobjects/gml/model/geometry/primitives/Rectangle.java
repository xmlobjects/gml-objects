/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.visitor.GeometryVisitor;

public class Rectangle extends AbstractSurfacePatch {
    private AbstractRingProperty exterior;

    public Rectangle() {
    }

    public Rectangle(AbstractRingProperty exterior) {
        setExterior(exterior);
    }

    public Rectangle(AbstractRing exterior) {
        this(new AbstractRingProperty(exterior));
    }

    public AbstractRingProperty getExterior() {
        return exterior;
    }

    public void setExterior(AbstractRingProperty exterior) {
        this.exterior = asChild(exterior);
    }

    public SurfaceInterpolation getInterpolation() {
        return SurfaceInterpolation.PLANAR;
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (exterior != null && exterior.getObject() != null)
            envelope.include(exterior.getObject().computeEnvelope());

        return envelope;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
}
