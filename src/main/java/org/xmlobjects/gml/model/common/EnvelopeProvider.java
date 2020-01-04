package org.xmlobjects.gml.model.common;

import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;

public interface EnvelopeProvider {
    void updateEnvelope(Envelope envelope, EnvelopeOptions options);
}
