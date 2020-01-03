package org.xmlobjects.gml.model.common;

import org.xmlobjects.gml.model.geometry.Envelope;

public interface EnvelopeProvider {
    Envelope computeEnvelope();
}
