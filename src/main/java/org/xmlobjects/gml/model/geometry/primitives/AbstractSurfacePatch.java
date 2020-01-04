package org.xmlobjects.gml.model.geometry.primitives;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.geometry.Envelope;

public abstract class AbstractSurfacePatch extends GMLObject {
    public abstract Envelope computeEnvelope();
}
