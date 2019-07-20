package org.xmlobjects.gml.model.feature;

import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.model.basicTypes.NilReason;
import org.xmlobjects.gml.model.geometry.Envelope;

public class BoundingShape extends GMLObject {
    private Envelope envelope;
    private NilReason nilReason;

    public BoundingShape() {
    }

    public BoundingShape(Envelope envelope) {
        setEnvelope(envelope);
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Envelope envelope) {
        this.envelope = asChild(envelope);
    }

    public NilReason getNilReason() {
        return nilReason;
    }

    public void setNilReason(NilReason nilReason) {
        this.nilReason = asChild(nilReason);
    }
}
