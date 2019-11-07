package org.xmlobjects.gml.model.temporal;

public abstract class AbstractTimeGeometricPrimitive extends AbstractTimePrimitive {
    private String frame;

    public String getFrame() {
        return frame != null ? frame : "#ISO-8601";
    }

    public boolean isSetFrame() {
        return frame != null;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }
}
