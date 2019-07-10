package org.xmlobjects.gml.model.geometry;

import java.util.List;

public interface SRSInformation {
    List<String> getAxisLabels();
    void setAxisLabels(List<String> axisLabels);
    List<String> getUomLabels();
    void setUomLabels(List<String> uomLabels);
}
