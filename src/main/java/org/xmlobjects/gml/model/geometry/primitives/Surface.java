/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.visitor.GeometryVisitor;
import org.xmlobjects.gml.visitor.ObjectVisitor;

public class Surface extends AbstractSurface {
    private SurfacePatchArrayProperty<?> patches;

    public Surface() {
    }

    public Surface(SurfacePatchArrayProperty<?> patches) {
        setPatches(patches);
    }

    public SurfacePatchArrayProperty<?> getPatches() {
        return patches;
    }

    public void setPatches(SurfacePatchArrayProperty<?> patches) {
        this.patches = asChild(patches);
    }

    @SuppressWarnings("unchecked")
    public void addPatch(AbstractSurfacePatch patch) {
        if (patches == null)
            setPatches(new SurfacePatchArrayProperty<>());

        ((SurfacePatchArrayProperty<AbstractSurfacePatch>) patches).getObjects().add(patch);
    }

    @Override
    public Envelope computeEnvelope() {
        Envelope envelope = new Envelope();
        if (patches != null && patches.isSetObjects()) {
            for (AbstractSurfacePatch patch : patches.getObjects())
                envelope.include(patch.computeEnvelope());
        }

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
