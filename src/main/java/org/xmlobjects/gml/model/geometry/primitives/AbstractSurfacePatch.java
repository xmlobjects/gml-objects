/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.visitor.VisitableGeometry;

public abstract class AbstractSurfacePatch extends GMLObject implements VisitableGeometry {
    public abstract Envelope computeEnvelope();
}
