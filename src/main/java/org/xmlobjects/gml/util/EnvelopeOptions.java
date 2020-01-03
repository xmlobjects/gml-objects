package org.xmlobjects.gml.util;

public class EnvelopeOptions {
    private boolean reuseExistingEnvelopes;
    private boolean setEnvelopeOnFeatures;

    private EnvelopeOptions() {
    }

    public static EnvelopeOptions defaults() {
        return new EnvelopeOptions();
    }

    public boolean isReuseExistingEnvelopes() {
        return reuseExistingEnvelopes;
    }

    public EnvelopeOptions reuseExistingEnvelopes(boolean reuseExistingEnvelopes) {
        this.reuseExistingEnvelopes = reuseExistingEnvelopes;
        return this;
    }

    public boolean isSetEnvelopeOnFeatures() {
        return setEnvelopeOnFeatures;
    }

    public EnvelopeOptions setEnvelopeOnFeatures(boolean setEnvelopeOnFeatures) {
        this.setEnvelopeOnFeatures = setEnvelopeOnFeatures;
        return this;
    }
}
